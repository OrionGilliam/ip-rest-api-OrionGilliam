package com.assignment.ogilliamproject.datasources;

import com.assignment.ogilliamproject.models.Statuses;

import java.util.HashMap;

public class datasource {

    private static HashMap<String, String> statuses = new HashMap<>();

    public static void addAddresses(String[] addresses) {
        for (String address : addresses) {
            //assures status of ip address does not change if added again
            if (!statuses.containsKey(address)) {
                statuses.put(address, Statuses.AVAILABLE);
            }
        }
    }

    //returns a json list of addresses
    public static String listAddresses() {
        return statuses.toString();
    }

    public static String releaseIp(String address) {
        if (statuses.containsKey(address)) {
            statuses.put(address, Statuses.AVAILABLE);
            return "success";
        } else {
            return notFound(address);
        }
    }

    public static String acquireIP(String address) {
        if (statuses.containsKey(address)) {
            statuses.put(address, Statuses.ACQUIRED);
            return "success";
        } else {
            return notFound(address);
        }
    }

    private static String notFound(String ip) {
        return "Add " + ip + " to the list before editing it";
    }
}
