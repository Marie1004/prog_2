public class SymptomList {
    // Instanzvariablen
    private boolean breathingProblem;
    private boolean fever;
    private boolean dryCough;
    private boolean soreThroat;
    private boolean runningNose;
    private boolean asthma;
    private boolean chronicLungDisease;
    private boolean headache;
    private boolean heartDisease;
    private boolean diabetes;
    private boolean hyperTension;
    private boolean fatigue;
    private boolean gastrointestinal;
    private boolean abroadTravel;
    private boolean contactWithCovidPatient;
    private boolean attendedLargeGathering;
    private boolean visitedPublicExposedPlaces;
    private boolean familyWorkingInPublicExposedPlaces;
    private boolean wearingMasks;
    private boolean sanitizationFromMarket;
    private boolean covid19;

    // Konstruktor
    public SymptomList(
            boolean _breathingProblem,
            boolean _fever,
            boolean _dryCough,
            boolean _soreThroat,
            boolean _runningNose,
            boolean _asthma,
            boolean _chronicLungDisease,
            boolean _headache,
            boolean _heartDisease,
            boolean _diabetes,
            boolean _hyperTension,
            boolean _fatigue,
            boolean _gastrointestinal,
            boolean _abroadTravel,
            boolean _contactWithCovidPatient,
            boolean _attendedLargeGathering,
            boolean _visitedPublicExposedPlaces,
            boolean _familyWorkingInPublicExposedPlaces,
            boolean _wearingMasks,
            boolean _sanitizationFromMarket,
            boolean _covid19
            ) {
        this.breathingProblem = _breathingProblem;
        this.fever = _fever;
        this.dryCough = _dryCough;
        this.soreThroat = _soreThroat;
        this.runningNose = _runningNose;
        this.asthma = _asthma;
        this.chronicLungDisease = _chronicLungDisease;
        this.headache = _headache;
        this.heartDisease = _heartDisease;
        this.diabetes = _diabetes;
        this.hyperTension = _hyperTension;
        this.fatigue = _fatigue;
        this.gastrointestinal = _gastrointestinal;
        this.abroadTravel = _abroadTravel;
        this.contactWithCovidPatient = _contactWithCovidPatient;
        this.attendedLargeGathering = _attendedLargeGathering;
        this.visitedPublicExposedPlaces = _visitedPublicExposedPlaces;
        this.familyWorkingInPublicExposedPlaces = _familyWorkingInPublicExposedPlaces;
        this.wearingMasks = _wearingMasks;
        this.sanitizationFromMarket = _sanitizationFromMarket;
        this.covid19 = _covid19;
    }

    public boolean isBreathingProblem() { return breathingProblem; }
    public boolean isFever() { return fever; }
    public boolean isDryCough() { return dryCough; }
    public boolean isSoreThroat() { return soreThroat; }
    public boolean isRunningNose() { return runningNose; }
    public boolean isAsthma() { return asthma; }
    public boolean isChronicLungDisease() { return chronicLungDisease; }
    public boolean isHeadache() { return headache; }
    public boolean isHeartDisease() { return heartDisease; }
    public boolean isDiabetes() { return diabetes; }
    public boolean isHyperTension() { return hyperTension; }
    public boolean isFatigue() { return fatigue; }
    public boolean isGastrointestinal() { return gastrointestinal; }
    public boolean isAbroadTravel() { return abroadTravel; }
    public boolean isContactWithCovidPatient() { return contactWithCovidPatient; }
    public boolean isAttendedLargeGathering() { return attendedLargeGathering; }
    public boolean isVisitedPublicExposedPlaces() { return visitedPublicExposedPlaces; }
    public boolean isFamilyWorkingInPublicExposedPlaces() { return familyWorkingInPublicExposedPlaces; }
    public boolean isWearingMasks() { return wearingMasks; }
    public boolean isSanitizationFromMarket() { return sanitizationFromMarket; }
    public boolean isCovid19() { return covid19; }



    public void setBreathingProblem(boolean breathingProblem) {
        this.breathingProblem = breathingProblem;
    }

    public void setFever(boolean fever) {
        this.fever = fever;
    }

    public void setDryCough(boolean dryCough) {
        this.dryCough = dryCough;
    }

    public void setSoreThroat(boolean soreThroat) {
        this.soreThroat = soreThroat;
    }

    public void setRunningNose(boolean runningNose) {
        this.runningNose = runningNose;
    }

    public void setAsthma(boolean asthma) {
        this.asthma = asthma;
    }

    public void setChronicLungDisease(boolean chronicLungDisease) {
        this.chronicLungDisease = chronicLungDisease;
    }

    public void setHeadache(boolean headache) {
        this.headache = headache;
    }

    public void setHeartDisease(boolean heartDisease) {
        this.heartDisease = heartDisease;
    }

    public void setDiabetes(boolean diabetes) {
        this.diabetes = diabetes;
    }

    public void setHyperTension(boolean hyperTension) {
        this.hyperTension = hyperTension;
    }

    public void setFatigue(boolean fatigue) {
        this.fatigue = fatigue;
    }

    public void setGastrointestinal(boolean gastrointestinal) {
        this.gastrointestinal = gastrointestinal;
    }

    public void setAbroadTravel(boolean abroadTravel) {
        this.abroadTravel = abroadTravel;
    }

    public void setContactWithCovidPatient(boolean contactWithCovidPatient) {
        this.contactWithCovidPatient = contactWithCovidPatient;
    }

    public void setAttendedLargeGathering(boolean attendedLargeGathering) {
        this.attendedLargeGathering = attendedLargeGathering;
    }

    public void setVisitedPublicExposedPlaces(boolean visitedPublicExposedPlaces) {
        this.visitedPublicExposedPlaces = visitedPublicExposedPlaces;
    }

    public void setFamilyWorkingInPublicExposedPlaces(boolean familyWorkingInPublicExposedPlaces) {
        this.familyWorkingInPublicExposedPlaces = familyWorkingInPublicExposedPlaces;
    }

    public void setWearingMasks(boolean wearingMasks) {
        this.wearingMasks = wearingMasks;
    }

    public void setSanitizationFromMarket(boolean sanitizationFromMarket) {
        this.sanitizationFromMarket = sanitizationFromMarket;
    }

    public void setCovid19(boolean covid19) {
        this.covid19 = covid19;
    }
}