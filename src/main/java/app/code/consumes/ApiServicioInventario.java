package app.code.consumes;

import app.code.trasient.ProductoDTO;
import app.code.trasient.ResultadoTrasient;
import app.code.trasient.InfoMovimientoTrasient;
import ec.edu.ups.trasient.DetlleProductoTrasient;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import java.util.List;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Carlos
 */
public class ApiServicioInventario {
    
    private String API_SERIVICIO_GUARDAR_PRODUCTO = "http://localhost:8080/ServidorMorochoCarlos/ws/inventario/guardar_producto";
    private String API_SERIVICIO_LISTAR_PRODUCTOS = "http://127.0.0.1:8080/ServidorMorochoCarlos/ws/inventario/productos";
    private String API_SERIVICIO_MOVIMIENTOS = "http://127.0.0.1:8080/ServidorMorochoCarlos/ws/inventario/movimietos_producto/";
    private String API_SERIVICIO_MOVIMIENTO_INGRESO = "http://127.0.0.1:8080/ServidorMorochoCarlos/ws/inventario/movimiento_ingreso";
    private String API_SERIVICIO_MOVIMIENTO_EGRESO = "http://127.0.0.1:8080/ServidorMorochoCarlos/ws/inventario/movimiento_egreso";

    
    public ResultadoTrasient apiServicioGuardarProducto(ProductoDTO producto) {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(API_SERIVICIO_GUARDAR_PRODUCTO);
        ResultadoTrasient respuesta = target.request()
                .post(Entity.json(producto), ResultadoTrasient.class);
        client.close();
        return respuesta;
    }

    public List<ProductoDTO> apiServicioObtenerProductos() {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(API_SERIVICIO_LISTAR_PRODUCTOS);
        List<ProductoDTO> respuesta = target.request().get(Response.class)
                      .readEntity(new GenericType<List<ProductoDTO>>() {});
        client.close();
        return respuesta;
    }
    
    
    public List<InfoMovimientoTrasient> apiServicioObtenerMovimientos(long idProducto) {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(API_SERIVICIO_MOVIMIENTOS + idProducto);
        List<InfoMovimientoTrasient> respuesta = target.request().get(Response.class)
                .readEntity(new GenericType<List<InfoMovimientoTrasient>>() {});
        client.close();
        return respuesta;
    }
    
    public ResultadoTrasient apiServicioMovimientoIngreso(List<DetlleProductoTrasient> detalles) {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(API_SERIVICIO_MOVIMIENTO_INGRESO);
        ResultadoTrasient respuesta = target.request()
                .post(Entity.json(detalles), ResultadoTrasient.class);
        client.close();
        return respuesta;
    }
    
        public ResultadoTrasient apiServicioMovimientoEgreso(List<DetlleProductoTrasient> detalles) {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(API_SERIVICIO_MOVIMIENTO_EGRESO);
        ResultadoTrasient respuesta = target.request()
                .post(Entity.json(detalles), ResultadoTrasient.class);
        client.close();
        return respuesta;
    }
}
