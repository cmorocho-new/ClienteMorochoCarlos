package app.code.consumes;

import app.code.trasient.ProductoDTO;
import app.code.trasient.ResultadoTrasient;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import java.util.List;

/**
 *
 * @author Carlos
 */
public class ApiServicioInventario {
    
    private String API_SERIVICIO_GUARDAR_PRODUCTO = "http://127.0.0.1:8080/ServidorMorochoCarlos/inventario/guardar_producto";
    private String API_SERIVICIO_LISTAR_PRODUCTOS = "http://127.0.0.1:8080/ServidorMorochoCarlos/inventario/";

    
    public ResultadoTrasient apiServicioGuardarProducto(ProductoDTO producto) {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(API_SERIVICIO_GUARDAR_PRODUCTO);
        ResultadoTrasient respuesta = target.request()
                .post(Entity.json(producto), ResultadoTrasient.class);
        client.close();
        return respuesta;
    }

    public ResultadoTrasient apiServicioGuardarDatosCliente(List<Object> datosCliente) {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(API_SERIVICIO_LISTAR_PRODUCTOS);
        ResultadoTrasient respuesta = target.request().post(Entity.json(datosCliente), ResultadoTrasient.class);
        client.close();
        return respuesta;
    }
}
