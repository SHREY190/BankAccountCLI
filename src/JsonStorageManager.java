import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;

public class JsonStorageManager {
    public static void storeAccounts(HashMap<Integer, Account> AccountLookup) {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        try (FileWriter writer = new FileWriter("src/Accounts.json")) {
            gson.toJson(AccountLookup, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static HashMap<Integer, Account> getStoredAccounts() {
        Gson gson = new Gson();

        try (FileReader reader = new FileReader("src/Accounts.json")) {
            Type type = new TypeToken<HashMap<Integer, Account>>() {
            }.getType();

            return gson.fromJson(reader, type);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new HashMap<>();
    }


//    public static
}
