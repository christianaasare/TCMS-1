package GsonTrial;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.*;

public class GSONApi {
    private File filename = new File("ClientStore.json");

    public void addNewClient(Client client){
        try{
            if (!filename.exists()){
                filename.createNewFile();
            }
            if (filename.exists()) {
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                // construct Type that tells Gson about the generic type
                Type clientType = new TypeToken<List<Client>>(){}.getType();
                //Reading Json objects from file
                FileReader fr = new FileReader(filename);
                //Wrapping Optional to check null
                List<Client> clients = gson.fromJson(fr, clientType);
                //Closing the file after being opened
                fr.close();

                // If it was an empty one create initial list
                if(clients == null){
                    clients = new ArrayList<>();
                }
                // Add new client to the list
                clients.add(client);
                // appending list of clients to file
                FileWriter fw  = new FileWriter(filename);
                gson.toJson(clients, fw);
                fw.close();
                System.out.println("New Client Added Successfully!!!");
            }
        }catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Error Occurred at | " + e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error Occurred at | " + e.getMessage());
        }
    }
    public List<Client> getAllClients(){

        try {

            Gson gson = new Gson();
            Type clientType = new TypeToken<List<Client>>(){}.getType();
            FileReader fr = new FileReader(filename);
            List<Client> clients = gson.fromJson(fr, clientType);
            fr.close();
            if(clients.isEmpty()){
                return new ArrayList<>();
            }else {
                return clients;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Error Occurred at | " + e.getMessage());
            return new ArrayList<>();

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error Occurred at | " + e.getMessage());
            return new ArrayList<>();
        }
    }

}
