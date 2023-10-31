package GerenciamentoDePedido.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import GerenciamentoDePedido.repository.PedidoRepository;
import gerenciamendoDePedidos.entities.pedido;


@Service
public class PedidoService {
	private final PedidoRepository pedidoRepository;
	
	@Autowired
	 public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    public List<pedido> getAllPedido (){
        return pedidoRepository.findAll();
    }

    public pedido getPedidoById(Long id) {
        Optional<pedido> Pedido = pedidoRepository.findById(id);
        return Pedido.orElse(null);
    }

    public pedido salvarPedido(pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    public pedido updatePedido(Long id, pedido updatedpedido) {
        Optional<pedido> existingPedido = pedidoRepository.findById(id);
        if (existingPedido.isPresent()) {
            updatedpedido.setId(id);
            return pedidoRepository.save(updatedpedido);
        }
        return null;
    }

    public boolean deletepedido(Long id) {
        Optional<pedido> existingPedido = pedidoRepository.findById(id);
        if (existingPedido.isPresent()) {
            pedidoRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
