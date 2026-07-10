package model;

import com.google.gson.annotations.SerializedName;

public class Api {
    @SerializedName(value = "citacao", alternate = {"quote", "text", "translations"})
    private String citacao;
    @SerializedName("author")
    private String autor;
    @SerializedName("work")
    private String  obra;
    @SerializedName("detected_source_language")
    private String lingua;
   

    public String getCitacao() {
        return citacao;
    }
    public void setCitacao(String citacao) {
        this.citacao = citacao;
    }
    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }
    public String getObra() {
        return obra;
    }
    public void setObra(String obra) {
        this.obra = obra;
    }
    @Override
    public String toString() {
        return "citacao=" + citacao + ", autor=" + autor + ", obra=" + obra + "]";
    }
    
}
