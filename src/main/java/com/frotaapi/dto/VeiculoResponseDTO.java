package com.frotaapi.dto;

public class VeiculoResponseDTO {

    private Long id;
    private String placa;
    private String modelo;
    private String marca;
    private Integer anoFabricacao;
    private Long km;
    private Boolean status;
    private String cor;
    private String renavam;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
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
