package GerenciamentoDePedido.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import gerenciamendoDePedidos.entities.pedido;

public interface PedidoRepository extends JpaRepository <pedido, Long> {

}
