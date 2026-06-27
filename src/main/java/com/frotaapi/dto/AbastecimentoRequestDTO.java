package com.frotaapi.dto;

import jakarta.validation.constraints.*;

public class AbastecimentoRequestDTO {

    @NotNull(message = "VeiculoId é obrigatório")
    @Positive(message = "VeiculoId deve ser um ID válido (positivo)")
    private Long veiculoId;
    @NotNull(message = "MotoristaId é obrigatório")
    @Positive(message = "MotoristaId deve ser um ID válido (positivo)")
    private Long motoristaId;
    @NotNull(message = "data não pode ser nulo")
    private java.time.LocalDateTime data;
    @NotNull(message = "litros não pode ser nulo")
    private Double litros;
    @DecimalMin(value = "0.0", message = "valor total não pode ser negativo")
    @NotNull(message = "valor total não pode ser nulo")
    private Double valorTotal;
    @NotNull(message = "km atual não pode ser nulo")
    private Integer kmAtual;
    @NotBlank(message = "posto não pode estar em branco")
    private String posto;
    @NotBlank(message = "combustivel não pode estar em branco")
    private String combustivel;

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
