package pl.qa.selenium.data.jdbc.model;

import pl.qa.selenium.data.jdbc.dbconnection.DBConnection;
import pl.qa.selenium.data.jdbc.dto.CurrencyDTO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CurrencyDbUtils {

    public List<CurrencyDTO> getAllCurrences() {
        Connection conn = DBConnection.getConnection();
        try {
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery("Select * from currencies");
            return mapCurrencyTableResultToDto(result);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    private List<CurrencyDTO> mapCurrencyTableResultToDto(ResultSet result) throws SQLException {
        List<CurrencyDTO> currencies = new ArrayList<>();
        while(result.next()){
            CurrencyDTO currency = mapCurrencyFromDbToDto(result);
            currencies.add(currency);

        }
        return currencies;
    }

    private CurrencyDTO mapCurrencyFromDbToDto(ResultSet result) throws SQLException {
        CurrencyDTO currency = new CurrencyDTO();
        currency.setId(result.getInt("id"));
        currency.setName(result.getString("name"));
        currency.setValue(result.getInt("value"));
        return currency;
    }

}
