package main.assignment_28_10_2024;

import java.util.*;

public class Duplicates {
    public static List<ClientBalance> removeDuplicates(List<ClientBalance> clientBalances) {
        Set<ClientBalance> clientBalanceSet = new HashSet<>(clientBalances);
        return new ArrayList<>(clientBalanceSet);
    }

    public static void main(String[] args) {
        List<ClientBalance> inputValues = List.of(
                new ClientBalance(
                    12345,
                        "client_1",
                        new GregorianCalendar(2022, GregorianCalendar.MAY, 20, 18, 50, 0),
                        1500
                ),
                new ClientBalance(
                        12345,
                        "client_1",
                        new GregorianCalendar(2022, GregorianCalendar.MAY, 20, 18, 50, 0),
                        1500
                ),
                new ClientBalance(
                        12345,
                        "client_1",
                        new GregorianCalendar(2022, GregorianCalendar.MAY, 20, 17, 50, 0),
                        1000
                ),
                new ClientBalance(
                        54321,
                        "client_2",
                        new GregorianCalendar(2022, GregorianCalendar.MAY, 20, 17, 50, 0),
                        500
                ),
                new ClientBalance(
                        54321,
                        "client_2",
                        new GregorianCalendar(2022, GregorianCalendar.MAY, 20, 18, 50, 0),
                        1000
                ),
                new ClientBalance(
                        54321,
                        "client_2",
                        new GregorianCalendar(2022, GregorianCalendar.MAY, 20, 18, 50, 0),
                        1000
                )
        );
        System.out.println(removeDuplicates(inputValues));
    }
}
