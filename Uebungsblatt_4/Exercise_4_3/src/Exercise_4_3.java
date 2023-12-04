import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Exercise_4_3 {
    public static void main(String[] args) throws FileNotFoundException {
        boolean[] userSymptoms;
        ArrayList<SymptomList> diagnosisList;
        ArrayList<SymptomList> bestDiagnosisList;
        boolean covid;

        // Laden der Diagnosetabelle
        diagnosisList = generateDiagnosisList();

        // Laden der Symptome des Nutzers
        userSymptoms = chatbot();

        // Finden der wahrscheinlichsten Diagnosen
        bestDiagnosisList = findMostLikelyDiagnoses(diagnosisList , userSymptoms);

        covid = calculateResult(bestDiagnosisList);

        if(covid) {
            System.out.println("\n\nThere is a chance that you have Covid.\n" +
                    "Please contact your doctor by telephone to discuss the next steps.\n" +
                    "Get well soon.");
        } else {
            System.out.println("\n\nIt is unlikely that you have Covid.\n" +
                    "You should still see a doctor if you are not feeling well and have yourself examined.\n" +
                    "Get well soon.");
        }
    }

    /**
     * Erstellen der ArrayList
     * mit den verschiedenen Symptom-Zusammensetzungen
     * zur Diagnoseermittlung
     *
     * @return diagnosisList
     * @throws FileNotFoundException
     */
    public static ArrayList<SymptomList> generateDiagnosisList() throws FileNotFoundException {
        boolean breathingProblem;
        boolean fever;
        boolean dryCough;
        boolean soreThroat;
        boolean runningNose;
        boolean asthma;
        boolean chronicLungDisease;
        boolean headache;
        boolean heartDisease;
        boolean diabetes;
        boolean hyperTension;
        boolean fatigue;
        boolean gastrointestinal;
        boolean abroadTravel;
        boolean contactWithCovidPatient;
        boolean attendedLargeGathering;
        boolean visitedPublicExposedPlaces;
        boolean familyWorkingInPublicExposedPlaces;
        boolean wearingMasks;
        boolean sanitizationFromMarket;
        boolean covid19;
        ArrayList<SymptomList> diagnosisList;
        File file;
        Scanner scanner;
        String line;
        String[] values;
        boolean[] booleanValues;

        // Erzeugen des Kunden-Objekts
        SymptomList symptomList = new SymptomList(
                false,
                false,
                false,
                false,
                false,
                false,
                false,
                false,
                false,
                false,
                false,
                false,
                false,
                false,
                false,
                false,
                false,
                false,
                false,
                false,
                false);
        // Erstellen der ArrayList
        diagnosisList = new ArrayList<SymptomList>();

        // Verweis auf die Datei
        file = new File("/Users/passis./Documents/GitHub/prog_2/Uebungsblatt_4/Exercise_4_3/inc/covid.csv");
        scanner = new Scanner(file);
        scanner.nextLine();


        while (scanner.hasNextLine()) {
            line = scanner.nextLine();

            // Zerlegen des Strings in Teilstrings
            values = line.split(",");

            booleanValues = new boolean[values.length];

            for(int i = 0; i < values.length; i++) {
                if(values[i].equals("Yes")) {
                    booleanValues[i] = true;
                } else {
                    booleanValues[i] = false;
                }
            }

            // Konvertiert einen String in einen Int-Wert
            breathingProblem = booleanValues[0];
            fever = booleanValues[1];
            dryCough = booleanValues[2];
            soreThroat = booleanValues[3];
            runningNose = booleanValues[4];
            asthma = booleanValues[5];
            chronicLungDisease = booleanValues[6];
            headache = booleanValues[7];
            heartDisease = booleanValues[8];
            diabetes  = booleanValues[9];
            hyperTension = booleanValues[10];
            fatigue = booleanValues[11];
            gastrointestinal = booleanValues[12];
            abroadTravel = booleanValues[13];
            contactWithCovidPatient = booleanValues[14];
            attendedLargeGathering = booleanValues[15];
            visitedPublicExposedPlaces = booleanValues[16];
            familyWorkingInPublicExposedPlaces = booleanValues[17];
            wearingMasks = booleanValues[18];
            sanitizationFromMarket = booleanValues[19];
            covid19 = booleanValues[20];

            symptomList = new SymptomList(
                    breathingProblem,
                    fever,
                    dryCough,
                    soreThroat,
                    runningNose,
                    asthma,
                    chronicLungDisease,
                    headache,
                    heartDisease,
                    diabetes,
                    hyperTension,
                    fatigue,
                    gastrointestinal,
                    abroadTravel,
                    contactWithCovidPatient,
                    attendedLargeGathering,
                    visitedPublicExposedPlaces,
                    familyWorkingInPublicExposedPlaces,
                    wearingMasks,
                    sanitizationFromMarket,
                    covid19);

            // Einfuegen des Kunden-Objekts in die Liste
            diagnosisList.add(symptomList);
        }
        scanner.close();
        return diagnosisList;
    }

    /**
     * Ermitteln der Namen der Symptome
     * @return symptomNames
     */
    public static String[] generateSymptomNames() throws FileNotFoundException {
        File file;
        Scanner scanner;
        String[] symptomNames;

        file = new File("/Users/passis./Documents/GitHub/prog_2/Uebungsblatt_4/Exercise_4_3/inc/covid.csv");
        scanner = new Scanner(file);

        String line = scanner.nextLine();

        // Zerlegen des Strings in Teilstrings
        symptomNames = line.split(",");

        return symptomNames;
    }

    /**
     * Abfrage der Symptome des Nutzers
     *
     * @return
     * @throws FileNotFoundException
     */
    public static boolean[] chatbot() throws FileNotFoundException {
        String[] symptomNames;
        Scanner userInput = new Scanner(System.in);
        boolean[] userSymptoms;

        // Laden der Symptom-Namen
        symptomNames = generateSymptomNames();

        // Erstellen eines Arrays fuer die Patientenantworten zu den einzelnen Symptomen
        userSymptoms = new boolean[symptomNames.length - 1];

        System.out.println("Hello, I'm Alex.\n" +
                "Please answer the following questions about your symptoms to find out if you could have COVID19.\n" +
                "(Answer with 1 for 'Yes' or 0 for 'No')");

        // Die Abfrage der Symptome beim Patienten durch den Chatbot
        for(int i = 0; i < (userSymptoms.length - 1); i++) {
            System.out.println("\nDo you have " + symptomNames[i]);

            if(userInput.nextInt() == 1) {
                userSymptoms[i] = true;
            } else {
                userSymptoms[i] = false;
            }
        }

        return userSymptoms;
    }

    public static ArrayList<SymptomList> findMostLikelyDiagnoses(ArrayList<SymptomList> diagnosisList , boolean[] userSymptoms) {
        int distance;
        int minDistance;
        ArrayList<SymptomList> bestDiagnosisList;

        minDistance = userSymptoms.length + 1;
        bestDiagnosisList = new ArrayList<SymptomList>();

        for(SymptomList s: diagnosisList) {
            distance = calculateDistance(s, userSymptoms);
            if(distance < minDistance) {
                minDistance = distance;
                bestDiagnosisList.clear();
            }
            if(distance == minDistance) {
                bestDiagnosisList.add(s);
            }
        }

        return bestDiagnosisList;
    }

    public static int calculateDistance(SymptomList s , boolean[] userSymptoms) {
        int distance;
        distance = 0;

        if(userSymptoms[0] != s.isBreathingProblem()) {distance++;}
        if(userSymptoms[1] != s.isFever()) {distance++;}
        if(userSymptoms[2] != s.isDryCough()) {distance++;}
        if(userSymptoms[3] != s.isSoreThroat()) {distance++;}
        if(userSymptoms[4] != s.isRunningNose()) {distance++;}
        if(userSymptoms[5] != s.isAsthma()) {distance++;}
        if(userSymptoms[6] != s.isChronicLungDisease()) {distance++;}
        if(userSymptoms[7] != s.isHeadache()) {distance++;}
        if(userSymptoms[8] != s.isHeartDisease()) {distance++;}
        if(userSymptoms[9] != s.isDiabetes()) {distance++;}
        if(userSymptoms[10] != s.isHyperTension()) {distance++;}
        if(userSymptoms[11] != s.isFatigue()) {distance++;}
        if(userSymptoms[12] != s.isGastrointestinal()) {distance++;}
        if(userSymptoms[13] != s.isAbroadTravel()) {distance++;}
        if(userSymptoms[14] != s.isContactWithCovidPatient()) {distance++;}
        if(userSymptoms[15] != s.isAttendedLargeGathering()) {distance++;}
        if(userSymptoms[16] != s.isVisitedPublicExposedPlaces()) {distance++;}
        if(userSymptoms[17] != s.isFamilyWorkingInPublicExposedPlaces()) {distance++;}
        if(userSymptoms[18] != s.isWearingMasks()) {distance++;}
        if(userSymptoms[19] != s.isSanitizationFromMarket()) {distance++;}

        return distance;
    }

    public static boolean calculateResult(ArrayList<SymptomList> bestDiagnosisList) {
        int yes;
        int no;
        boolean answer;

        yes = 0;
        no = 0;

        for(SymptomList s: bestDiagnosisList) {
            if(s.isCovid19()) {
                yes++;
            } else {
                no++;
            }
        }

        if(yes >= no) {
            answer = true;
        } else {
            answer = false;
        }

        return answer;
    }
}