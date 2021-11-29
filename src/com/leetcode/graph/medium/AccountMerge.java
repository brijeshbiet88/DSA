package com.leetcode.graph.medium;

import java.util.*;
import java.util.stream.Collectors;

public class AccountMerge {
    public static void main(String[] args) {
        System.out.println("-----------------Test Case 1--------------------");
        List<List<String>> accounts1 = new ArrayList<List<String>>();
        Set<String> emails1 = new TreeSet<String>();
        emails1.add("johnsmith@mail.com");
        emails1.add("john_newyork@mail.com");
        Account account1 = new Account("John" , emails1);
        accounts1.add(account1.toStringList());

        Set<String> emails2 = new TreeSet<String>();
        emails2.add("johnsmith@mail.com");
        emails2.add("john00@mail.com");
        Account account2 = new Account("John" , emails2);
        accounts1.add(account2.toStringList());

        Set<String> emails3 = new TreeSet<String>();
        emails3.add("mary@mail.com");
        Account account3 = new Account("Mary" , emails3);
        accounts1.add(account3.toStringList());

        Set<String> emails4 = new TreeSet<String>();
        emails4.add("johnnybravo@mail.com");
        Account account4 = new Account("John" , emails4);
        accounts1.add(account4.toStringList());

        List<List<String>> result = accountsMerge(accounts1);
        System.out.println("Print Merged Accounts : ");

        result.forEach(acc->{
            System.out.println();
            acc.forEach(s-> System.out.print(s+"    "));
        });

        System.out.println();
    }

    public static List<List<String>> accountsMerge(List<List<String>> accounts) {
        // Create UF on the no of accounts that we have
        UnionFind unionFind = new UnionFind(accounts.size());

        Map<String, Integer> emailAccIdMap = new HashMap<>();
        for (int accountId = 0; accountId < accounts.size(); accountId++) {

            List<String> account = accounts.get(accountId);
            List<String> emails =  account.subList(1, account.size());
            for (String email : emails) {
                if (!emailAccIdMap.containsKey(email)) {
                    emailAccIdMap.put(email, accountId);
                } else {
                    // there's an account with this email already, so use the UF struct to connect them
                    int previousAccountIdWithThisEmail = emailAccIdMap.get(email);
                    unionFind.union(previousAccountIdWithThisEmail, accountId);
                }
            }
        }

        // go through each account and find the UF root and merge
        Map<Integer, Account> rootAccounts = new HashMap<>();
        for (int accId = 0; accId < accounts.size(); accId++) {
            List<String> account = accounts.get(accId);

            int rootAccId = unionFind.getAbsoluteParent(accId);
            if (!rootAccounts.containsKey(rootAccId)) {
                String rootAccName = accounts.get(rootAccId).get(0);
                rootAccounts.put(rootAccId, new Account(rootAccName));
            }
            List<String> emails =  account.subList(1, account.size());
            rootAccounts.get(rootAccId).emails.addAll(emails);
        }

        return rootAccounts.values().stream()
                .map(acc -> acc.toStringList())
                .collect(Collectors.toList());
    }

    static class UnionFind {
        static int[] parent;
        UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }

        private static void union(int x, int y) {
            int pX = getAbsoluteParent(x);
            int pY = getAbsoluteParent(y);
            if(pX != pY){
                parent[pX] = pY;
            }
        }

        private static int getAbsoluteParent(int i){
            if(parent[i]==i){
                // absolute parent
                return i;
            }
            parent[i]=getAbsoluteParent(parent[i]);
            return parent[i];
        }
    }

    static class Account {
        String name;
        Set<String> emails = new TreeSet<>();

        Account(String name) {
            this.name = name;
        }

        Account(String name , Set<String> emails) {
            this.name = name;
            this.emails = emails;
        }

        List<String> toStringList() {
            List<String> list = new ArrayList<>();
            list.add(name);
            list.addAll(emails);
            return list;
        }
    }
}
