package com.frotaapi.dto;

public class AbastecimentoResponseDTO {

    private Long id;
    private Long veiculoId;
    private Long motoristaId;
    private java.time.LocalDateTime data;
    private Double litros;
    private Double valorTotal;
    private Integer kmAtual;
    private String posto;
    private String combustivel;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getVeiculoId() { return veiculoId; }
    public void setVeiculoId(Long veiculoId) { this.veiculoId = veiculoId; }
    public Long getMotoristaId() { return motoristaId; }
    public void setMotoristaId(Long motoristaId) { this.motoristaId = motoristaId; }
    public java.time.LocalDateTime getData() { return data; }
    public void setData(java.time.LocalDateTime data) { this.data = data; }
    public Double getLitros() { return litros; }
    public void setLitros(Double litros) { this.litros = litros; }
    public Double getValorTotal() { return valorTotal; }
    public void setValorTotal(Double valorTotal) { this.valorTotal = valorTotal; }
    public Integer getKmAtual() { return kmAtual; }
    public void setKmAtual(Integer kmAtual) { this.kmAtual = kmAtual; }
    public String getPosto() { return posto; }
    public void setPosto(String posto) { this.posto = posto; }
    public String getCombustivel() { return combustivel; }
    public void setCombustivel(String combustivel) { this.combustivel = combustivel; }
}
