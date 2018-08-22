package com.lynden.example.latlong;

import com.lynden.example.latlong.*;
import com.lynden.example.latlong.Casella;
import com.lynden.example.latlong.FMezzo;
import com.lynden.example.latlong.MazzoObiettivo;
import com.lynden.example.latlong.MazzoPercorso;
import com.lynden.example.latlong.Mezzo;
import com.lynden.example.latlong.Percorso;
import com.lynden.gmapsfx.GoogleMapView;
import com.lynden.gmapsfx.MapComponentInitializedListener;
import com.lynden.gmapsfx.javascript.event.UIEventType;
import com.lynden.gmapsfx.javascript.object.*;

import java.io.IOException;
import java.net.URL;

import java.util.*;

import com.lynden.gmapsfx.service.geocoding.GeocodingService;
import com.lynden.gmapsfx.shapes.Polyline;
import com.lynden.gmapsfx.shapes.PolylineOptions;
import com.lynden.gmapsfx.service.geocoding.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import com.fasterxml.jackson.databind.*;
import com.google.gson.*;

import java.lang.*;


import javafx.scene.control.*;
import javafx.event.*;
import javafx.scene.paint.Color;
import javafx.scene.image.*;
import netscape.javascript.JSObject;
import sun.tools.tree.BooleanExpression;


import java.io.*;

public class LatLongFXMLController implements Initializable,MapComponentInitializedListener{


    @FXML
    private GoogleMapView googleMapView;
    private GoogleMap map;
    private GeocodingService geocodingService;
    private HashMap<String,GeocoderGeometry> geocodingResults =new HashMap();
    private com.lynden.example.latlong.Giocatore giocatore =new com.lynden.example.latlong.Giocatore(1,"Giocatore1");


    @FXML
    private Button dadoButton;
    public Button TurnoButton;
    public Label NumberDado;
    public Label NumeroMezzo;
    public Label ErroreDado;
    boolean Primo=true;
    public ImageView DadoImage;  //per impostare immagine dado
    public Label CartaObiettivo;
    public Label CartaPercorsoPartenza;
    public Label CartaPercorsoArrivo;
    public Label GiocatoreName;   //per impostare nome giocatore in gioco


    /**********   Funzione per lanciare il Dado    ************/
    @FXML
    private void calcola(final ActionEvent event) {
        event.consume();


        int n=giocatore.LanciaDado();
        giocatore.setMezzo(n);

        NumeroMezzo.setText(String.valueOf(giocatore.getMezzo().size()));


        /****** Controllo su lancio dado doppio *****/
        if(Primo==true) {

            /****** Set Immagine dado*****/
            if(n==1) {
                Image dado= new Image("http://oi64.tinypic.com/2dluf4p.jpg");
                DadoImage.setImage(dado);
            }
            else if (n==2){
                Image dado= new Image("http://oi67.tinypic.com/652xxw.jpg");
                DadoImage.setImage(dado);
            }
            else if (n==3){
                Image dado= new Image("http://oi64.tinypic.com/1z1wyki.jpg");
                DadoImage.setImage(dado);
            }
            else if (n==4){
                Image dado= new Image("http://oi64.tinypic.com/2qthbgp.jpg");
                DadoImage.setImage(dado);
            }
            else if (n==5){
                Image dado= new Image("http://oi66.tinypic.com/261km5s.jpg");
                DadoImage.setImage(dado);
            }
            else if (n==6){
                Image dado= new Image("http://oi63.tinypic.com/2ccphzb.jpg");
                DadoImage.setImage(dado);
            }
            Primo=false;
        }
        dadoButton.setDisable(true);

    }




    /**********   Funzione cacolo randomico della Carta Obiettivo del Giocatore   ************/
    @FXML
    private void CartaObiettivo(final ActionEvent event) {
        event.consume();
        Random run = new Random();
        int n = run.nextInt(3)+1;
        if(n==1) {
            CartaObiettivo.setText("Città Obiettivo: Roma");
        }
        else if (n==2){
            CartaObiettivo.setText("Città Obiettivo: Parigi");
        }
        else if (n==3){
            CartaObiettivo.setText("Città Obiettivo: Milano");
        }
        CartaObiettivo.setTextFill(Color.web("white"));

    }



    @Override
    public void initialize(URL url, ResourceBundle rb) {
        googleMapView.addMapInializedListener(this);
    }
    @Override
    public void mapInitialized() {
        //SERVIZIO ESTERNO PER FARE JSON PER AVERE COORDINATE CITTA'
       /*try{
           geocodingService = new GeocodingService();
           synchronized (geocodingService){
               FileReader fw = new FileReader("ciao.txt");
               BufferedReader b=new BufferedReader(fw);
               HashMap x= new HashMap();
               while(b.readLine()!=null) {
                   x.put(Integer.parseInt(b.readLine()), b.readLine());
               }
               Map<Integer, String> tree = new TreeMap<Integer, String>(x);
               for(Map.Entry entry : tree.entrySet()) {

                    this.geocodingservice(entry);
           }

       }
       }
        catch (Exception e){

        }*/
       try {//LEGGO DAL JSON LE CITTA' CON LE COORDINATE

           FileReader fw = new FileReader("citta.json");
           ObjectMapper objectMapper = new ObjectMapper();
           HashMap<String, LatLong> maplat = new HashMap<>();


           com.google.gson.JsonParser jsonParser = new com.google.gson.JsonParser();
           JsonArray object = (JsonArray) jsonParser.parse(fw);
           for (int i = 0; i < object.size(); i++) {
               LatLong l = new LatLong(object.get(i).getAsJsonObject().get("latitude").getAsDouble(),
                       object.get(i).getAsJsonObject().get("longitude").getAsDouble());
               maplat.put(object.get(i).getAsJsonObject().get("variableName").toString(), l);
           }


           //DISABILITO TUTTO QUELLO NON NECESSARIO
           MapOptions mapOptions = new MapOptions();
           mapOptions.center(new LatLong(45.70618, 10.01953))
                   .mapType(MapTypeIdEnum.ROADMAP)
                   .zoom(4)
                   //per disabilitare streetview, zoom, scroll e maptype
                   .scrollWheel(false)
                   .maxZoom(5)
                   .streetViewControl(false)
                   .zoomControl(true)
                   .mapTypeControl(false)
                   .overviewMapControl(false)
                   .panControl(false)
                   .rotateControl(false)
                   .scaleControl(false);
           //CREO TUTTI I MARKER E LI POSIZIONO SULLA MAPPA
           ArrayList<Marker> markers = new ArrayList<Marker>();
           ArrayList<LatLong> latLongs = new ArrayList<>();
           for (Map.Entry entry : maplat.entrySet()) {
               MarkerOptions options = new MarkerOptions();


               /*********Disabilito la visione di tutti i marker ******/
               options.visible(Boolean.FALSE);

               LatLong latLong = (LatLong) entry.getValue();
               latLongs.add(latLong);
               options.position(latLong);
               // options.icon("http://oi64.tinypic.com/2vifno1.jpg");
               //     options.icon("http://oi64.tinypic.com/xe0jeo.jpg");
               // options.icon("http://oi64.tinypic.com/aomey1.jpg");
               //options.icon("http://oi65.tinypic.com/2ntl89w.jpg");
               //options.icon("http://oi64.tinypic.com/2zf7vhy.jpg");
               // options.icon("https://media.game.es/Img-statics/nav/pokemonicon.png");
               Marker m = new Marker(options);
               markers.add(m);
           }


           map = googleMapView.createMap(mapOptions, false);


           final Polyline[] polyline = {null};


           map.addMarkers(markers);


           /******** Scelta città obiettivo*******/
           Random run = new Random();
           FMezzo factory = new FMezzo();
           factory.CreaVagone(giocatore);
           ArrayList<Giocatore> giocatoreArrayList = new ArrayList<Giocatore>();
           giocatoreArrayList.add(giocatore);
           Partita partita = new Partita();
           partita.AvviaPartita(giocatoreArrayList, "Europa");

           /********* Imposta Nome Giocatore ********/
           GiocatoreName.setText(giocatore.getUsername());
           GiocatoreName.setTextFill(Color.web("red"));


           /********* Impostare Carta Percorso e Obiettivo *******/
           FMappa mappap = new FMappa(giocatoreArrayList, "Europa");
           mappap.CreaMappa();

           ArrayList<Percorso> percorsi = null;
           percorsi = mappap.DammiPercorsi();

           MazzoPercorso mazzoPercorso = new MazzoPercorso();
           mazzoPercorso = mazzoPercorso.getIstance(percorsi);

           MazzoObiettivo mazzoObiettivo = new MazzoObiettivo();
           mazzoObiettivo = mazzoObiettivo.getIstance(mappap.getCitta());

           giocatore.PescaDueCarte();
           CartaObiettivo CartaObbGioc1 = giocatore.ChiediCartaObiettivo();
           CartaPercorso CartaPercGioc1 = giocatore.ChiediCartaPercorso();

           CartaObiettivo.setText("Città obiettivo: " + CartaObbGioc1.getCittaObiettivo().getNome());
           CartaPercorsoPartenza.setText("Partenza:" + CartaPercGioc1.getCittaPartenza().getNome());
           CartaPercorsoArrivo.setText("Arrivo:" + CartaPercGioc1.getCittaArrivo().getNome());
           //CartaObiettivo.setTextFill(Color.web("white"));


           /*****setto la città di partenza mettendo un Marker *******/
           for (int i = 0; i < mappap.getCitta().size(); i++) {
               LatLong coorPartenza = mappap.getCitta().get(i).getCoordinate();
               if (mappap.getCitta().get(i).getNome().equals(CartaPercGioc1.getCittaPartenza().getNome())) {
                   FMezzo fMezzo=new FMezzo();
                   Mezzo mezGioc1= fMezzo.CreaVagone(giocatore);
                   mappap.getCitta().get(i).setMezzo(mezGioc1);

                   MarkerOptions MarkerPartenza = new MarkerOptions();
                   MarkerPartenza.position(coorPartenza);
                   MarkerPartenza.visible(Boolean.TRUE);
                   Marker m1 = new Marker(MarkerPartenza);
                   markers.add(m1);
                   map.addMarkers(markers);



                   //Citta cit = percorsi.get(i).getCittaArrivo();
                   //System.out.println(CartaPercGioc1.getCittaPartenza());
                   //System.out.println(CartaPercGioc1.getCittaPartenza());
                   //System.out.println(cit.getCoordinate().getLatitude());
               }
           }


           /********* Impostare i Percorsi della Mappa *******/
           for (int j = 0; j < percorsi.size(); j++) {
               Percorso p = percorsi.get(j);

               ArrayList<Casella> caselle = p.getCaselle();
               for (int i = 0; i < caselle.size(); i++) {
                   LatLong[] Prova = {caselle.get(i).getInizio(), caselle.get(i).getFine()};
                   //p.CheckSuiVicini(caselle.get(i));
                   PolylineOptions pippo = new PolylineOptions();
                   pippo.path(new MVCArray(Prova))
                           .clickable(true)
                           .draggable(false)
                           .strokeColor("gray")
                           .strokeWeight(6)
                           .visible(true);
                   polyline[0] = new Polyline(pippo);
                   map.addMapShape(polyline[0]);
                   Polyline finalPolyline = polyline[0];
                   int finalI = i;
                   map.addUIEventHandler(polyline[0], UIEventType.click, (JSObject obj) -> {

                       MVCArray path = finalPolyline.getPath();
                       pippo.path(path);
                       /****** per trovare la casella nella mappa******/
                       String coordinata = String.valueOf(path.getAt(0));
                       String[] LatLinea = coordinata.split(",");
                       CartaPercorso c = giocatore.ChiediCartaPercorso();
                       ArrayList<Percorso> percorsos=new ArrayList<>();
                       for(int a=0; a<mappap.DammiPercorsi().size();a++){
                           Percorso per1 = mappap.DammiPercorsi().get(a);
                           if(c.getCittaPartenza().getNome().equals(per1.getCittapartenza().getNome()))
                               percorsos.add(per1);
                       }





                       double Lat = Double.valueOf(LatLinea[0].replace("(", ""));
                       double Long = Double.valueOf(LatLinea[1].replace(")", ""));
                       LatLong LongCasellaInizio = caselle.get(finalI).getInizio();
                       LatLong LongCasellaFine = caselle.get(finalI).getFine();
                       Casella C = caselle.get(finalI);

                       if (LongCasellaInizio.getLatitude() == Lat && LongCasellaInizio.getLongitude() == Long) {
                            /******** IFFONE PER TROVARE I PERCORSI A CUI APPARTIENE LA CITTA DI PARTENZA DEL GIOCATORE*******/
                           if (p.getCittapartenza().CheckOccupata() && (percorsos.get(0).getCaselle().get(0).getId()==0||
                                   percorsos.get(1).getCaselle().get(0).getId()==0||percorsos.get(2).getCaselle().get(0).getId()==0||
                                   percorsos.get(3).getCaselle().get(0).getId()==0)||(percorsos.get(0).getCaselle().get(percorsos.get(0).getCaselle().size()).getId()==percorsos.get(0).getCaselle().get(percorsos.get(0).getCaselle().size()).getId()||
                                   percorsos.get(1).getCaselle().get(percorsos.get(1).getCaselle().size()).getId()==percorsos.get(1).getCaselle().get(percorsos.get(1).getCaselle().size()).getId()||
                                           percorsos.get(2).getCaselle().get(percorsos.get(2).getCaselle().size()).getId()==percorsos.get(2).getCaselle().get(percorsos.get(2).getCaselle().size()).getId()||
                                                   percorsos.get(3).getCaselle().get(percorsos.get(3).getCaselle().size()).getId()==percorsos.get(3).getCaselle().get(percorsos.get(3).getCaselle().size()).getId())
                                   ||  (
                                           percorsos.get(0).CheckSuiVicini(C) ||
                                                   percorsos.get(1).CheckSuiVicini(C) ||
                                                   percorsos.get(2).CheckSuiVicini(C) ||
                                                   percorsos.get(3).CheckSuiVicini(C)

                           )

                                   ){
                                   giocatore.PosizionaMezzo(C);


                               if (giocatore.getMezzo() == null) {
                                   NumeroMezzo.setText(String.valueOf(0));
                                   pippo.strokeColor("red");
                                   finalPolyline.setVisible(false);
                                   //giocatore.PosizionaMezzo(giocatore.getMezzo().get(i));
                                   Polyline polyline1 = new Polyline(pippo);
                                   map.addMapShape(polyline1);
                                   TurnoButton.setVisible(true);
                               } else if (giocatore.getMezzo().size() > 0) {
                                   NumeroMezzo.setText(String.valueOf(giocatore.getMezzo().size()));
                                   pippo.strokeColor("red");
                                   finalPolyline.setVisible(false);
                                   //giocatore.PosizionaMezzo(giocatore.getMezzo().get(i));
                                   Polyline polyline1 = new Polyline(pippo);
                                   map.addMapShape(polyline1);
                               }


                           }

                       }
                   });



               }

               /******* Controllo sulla contiguità delle caselle nel posizionamento **********/



           }
       }

        catch (Exception e){
            e.printStackTrace();
        }






    }
    //MULTIPLE GEOCODING REQUEST
    public void geocodingservice(Map.Entry entry) throws IOException, InterruptedException {
                String s = (String) entry.getValue();
                geocodingService.geocode(s, (GeocodingResult[] results, GeocoderStatus status) -> {
                if(status.name()=="OK"){
                    try{
                        this.geocodingResults.putIfAbsent(results[0].getFormattedAddress(),results[0].getGeometry());
                        this.function();
                    }
                catch (Exception e) {
                    e.printStackTrace();
                }
                }
                else{

                        try {
                            Thread.sleep(20000);
                            this.geocodingservice(entry);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                }

            });

        }
    //JSON PRINTING OF GEOCODING REQUEST
    public void function() throws IOException {

            ObjectMapper mapper =new ObjectMapper();
            String s=new String();
            FileOutputStream prova = new FileOutputStream("citta.json");
            PrintStream scrivi = new PrintStream(prova);
            mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
            for(Map.Entry<String, GeocoderGeometry> entry : this.geocodingResults.entrySet()){
                s=mapper.writeValueAsString(entry.getKey())+
                        mapper.writeValueAsString(entry.getValue().getLocation());
                 scrivi.print(s+'\n');

            }
            scrivi.close();
    }
    /*public Polyline  equazioneretta(LatLong l,LatLong l1){
        System.out.println("p1"+l);
        System.out.println("p2"+l1);
        double res;
        double res1;

            return polyline;
        }



    }
*/


}
