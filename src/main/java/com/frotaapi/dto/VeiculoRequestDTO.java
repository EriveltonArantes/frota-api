package com.frotaapi.dto;

import jakarta.validation.constraints.*;

public class VeiculoRequestDTO {

    @NotBlank(message = "placa não pode estar em branco")
    private String placa;
    @NotBlank(message = "modelo não pode estar em branco")
    private String modelo;
    @NotBlank(message = "marca não pode estar em branco")
    private String marca;
    @Min(value = 0, message = "ano fabricacao não pode ser negativo")
    @NotNull(message = "ano fabricacao não pode ser nulo")
    private Integer anoFabricacao;
    @NotNull(message = "km não pode ser nulo")
    private Long km;
    @NotNull(message = "status não pode ser nulo")
    private Boolean status;
    @NotBlank(message = "cor não pode estar em branco")
    private String cor;
    @NotBlank(message = "renavam não pode estar em branco")
    private String renavam;

    public String getPlaca() { return placa; }
    public void setPlaca(String placa) { this.placa = placa; }
    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }
    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }
    public Integer getAnoFabricacao() { return anoFabricacao; }
    public void setAnoFabricacao(Integer anoFabricacao) { this.anoFabricacao = anoFabricacao; }
    public Long getKm() { return km; }
    public void setKm(Long km) { this.km = km; }
    public Boolean getStatus() { return status; }
    public void setStatus(Boolean status) { this.status = status; }
    public String getCor() { return cor; }
    public void setCor(String cor) { this.cor = cor; }
    public String getRenavam() { return renavam; }
    public void setRenavam(String renavam) { this.renavam = renavam; }
}
