package louis.matutino.com.matutinolabexercise5;


public class AndroidVersion {
    private int logo;
    private String name, varInfo, varCountry, varCEO, varIndustry;

    public AndroidVersion(int logo, String varCountry, String varIndustry, String name, String varCEO) {
        this.logo = logo;
        this.name = name;
        this.varCEO = varCEO;
        this.varCountry = varCountry;
        this.varIndustry = varIndustry;
    }

    public int getLogo() {
        return logo;
    }

    public String getName() {
        return name;
    }

    public String getVarInfo() {
        return varInfo;
    }

    public String getVarCountry() {
        return varCountry;
    }

    public String getVarCEO() {
        return varCEO;
    }

    public String getVarIndustry() {
        return varIndustry;
    }
}