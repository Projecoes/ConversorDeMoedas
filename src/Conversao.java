import com.google.gson.annotations.SerializedName;

public class Conversao {
    @SerializedName("base_code")
    private String moedaDeReferencia;

    @SerializedName("conversion_result")
    private Double resultadoConversao;

    @SerializedName("target_code")
    private String moedaParaConversao;

    @SerializedName("conversion_rate")
    private Double taxaDeConversao;

    public Double getResultadoConversao() {
        return resultadoConversao;
    }

    public Double getTaxaDeConversao() {
        return taxaDeConversao;
    }

     @Override
    public String toString() {
        return String.format("O valor convertido é %.2f %s com taxa de conversão de %.4f para %s.",
                resultadoConversao, moedaParaConversao, taxaDeConversao, moedaDeReferencia);
    }
}