package br.com.meuprojeto.kanbanapi.config;

import br.com.meuprojeto.kanbanapi.models.Dispositivo;
import br.com.meuprojeto.kanbanapi.models.EstacaoSimulada;
import br.com.meuprojeto.kanbanapi.models.ItemSimulado;
import br.com.meuprojeto.kanbanapi.repositories.DispositivoRepository;
import br.com.meuprojeto.kanbanapi.repositories.EstacaoSimuladaRepository;
import br.com.meuprojeto.kanbanapi.repositories.ItemSimuladoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired private EstacaoSimuladaRepository estacaoRepo;
    @Autowired private ItemSimuladoRepository itemRepo;
    @Autowired private DispositivoRepository dispositivoRepo;

    @Override
    public void run(String... args) throws Exception {
        // Verifica se já existem dados para não duplicar
        if (estacaoRepo.count() == 0) {
            System.out.println("Criando dados iniciais...");

            EstacaoSimulada estacaoA = new EstacaoSimulada();
            estacaoA.setNomeEstacao("BANCADA-A-01");
            estacaoA.setDescricao("Bancada de montagem do produto X");
            estacaoRepo.save(estacaoA);

            ItemSimulado itemAzul = new ItemSimulado();
            itemAzul.setNomeItem("Componente Azul");
            itemAzul.setSkuItem("SKU-COMP-AZUL");
            itemRepo.save(itemAzul);

            Dispositivo disp1 = new Dispositivo();
            disp1.setApiKey(UUID.randomUUID().toString()); // Gera uma API Key aleatória
            disp1.setEstacao(estacaoA);
            disp1.setItem(itemAzul);
            dispositivoRepo.save(disp1);

            System.out.println("Dados iniciais criados com sucesso!");
        }
    }
}