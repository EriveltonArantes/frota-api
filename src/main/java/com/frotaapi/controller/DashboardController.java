package com.frotaapi.controller;

import com.frotaapi.model.Veiculo;
import com.frotaapi.model.Motorista;
import com.frotaapi.model.Manutencao;
import com.frotaapi.model.Abastecimento;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;

@Tag(name = "Dashboard", description = "KPIs e totais do sistema")
@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {

    @Autowired
    private com.frotaapi.repository.VeiculoRepository veiculoRepository;

    @Autowired
    private com.frotaapi.repository.MotoristaRepository motoristaRepository;

    @Autowired
    private com.frotaapi.repository.ManutencaoRepository manutencaoRepository;

    @Autowired
    private com.frotaapi.repository.AbastecimentoRepository abastecimentoRepository;

    @Operation(summary = "Resumo com totais, somas e gráficos de status")
    @Transactional(readOnly = true)
    @GetMapping("/resumo")
    public Map<String, Object> resumo() {
        Map<String, Object> resumo = new LinkedHashMap<>();
        resumo.put("totalVeiculo", veiculoRepository.count());
        resumo.put("somaKmVeiculo", veiculoRepository.findAll().stream().filter(e -> e.getKm() != null).mapToLong(e -> e.getKm()).sum());
        resumo.put("graficoVeiculo", veiculoRepository.findAll().stream()
            .collect(java.util.stream.Collectors.groupingBy(
                item -> String.valueOf(item.getStatus()),
                java.util.LinkedHashMap::new,
                java.util.stream.Collectors.counting())));
        resumo.put("totalMotorista", motoristaRepository.count());
        resumo.put("totalManutencao", manutencaoRepository.count());
        resumo.put("somaCustoManutencao", manutencaoRepository.findAll().stream().map(e -> e.getCusto()).filter(v -> v != null).reduce(java.math.BigDecimal.ZERO, java.math.BigDecimal::add));
        resumo.put("totalAbastecimento", abastecimentoRepository.count());
        resumo.put("somaLitrosAbastecimento", abastecimentoRepository.findAll().stream().filter(e -> e.getLitros() != null).mapToDouble(e -> e.getLitros()).sum());
        return resumo;
    }
}
