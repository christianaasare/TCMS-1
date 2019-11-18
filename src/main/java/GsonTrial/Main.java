package GsonTrial;



    public class Main {
        public static void main(String[] args) {
            Client client = new Client(234,"Christiana Asare","0244333441","chris@turntabl.io","Libya Street");

           GSONApi clientController = new GSONApi();
            //Adding new client
//            clientController.addNewClient(client);

            //Getting all clients
            System.out.println(clientController.getAllClients());
        }
    }

