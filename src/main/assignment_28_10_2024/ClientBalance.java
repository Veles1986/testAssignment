package main.assignment_28_10_2024;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Objects;

public class ClientBalance {
    private int client_id;
    private String client_name;
    private Calendar client_balance_date;
    private double client_balance_value;

    public ClientBalance(int client_id, String client_name, Calendar client_balance_date, double client_balance_value) {
        this.client_id = client_id;
        this.client_name = client_name;
        this.client_balance_date = client_balance_date;
        this.client_balance_value = client_balance_value;
    }

    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    public String getClient_name() {
        return client_name;
    }

    public void setClient_name(String client_name) {
        this.client_name = client_name;
    }

    public Calendar getClient_balance_date() {
        return client_balance_date;
    }

    public void setClient_balance_date(Calendar client_balance_date) {
        this.client_balance_date = client_balance_date;
    }

    public double getClient_balance_value() {
        return client_balance_value;
    }

    public void setClient_balance_value(double client_balance_value) {
        this.client_balance_value = client_balance_value;
    }

    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        return "\n{"
                + "client_id = " + client_id
                + ", client_name = '" + client_name + '\''
                + ", client_balance_date = " + dateFormat.format(client_balance_date.getTime())
                + ", client_balance_value=" + client_balance_value
                + "}";
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        ClientBalance that = (ClientBalance) object;
        return client_id == that.client_id
                && Double.compare(client_balance_value, that.client_balance_value) == 0
                && Objects.equals(client_name, that.client_name)
                && Objects.equals(client_balance_date, that.client_balance_date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(client_id, client_name, client_balance_date, client_balance_value);
    }
}
