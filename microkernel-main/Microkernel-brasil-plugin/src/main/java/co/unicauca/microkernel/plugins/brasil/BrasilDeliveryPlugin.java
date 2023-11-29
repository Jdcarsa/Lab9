package co.unicauca.microkernel.plugins.brasil;

import co.unicauca.microkernel.common.entities.Delivery;
import co.unicauca.microkernel.common.entities.Product;
import co.unicauca.microkernel.common.interfaces.IDeliveryPlugin;

/**
 * Plugin para envios a Brasil
 *
 * @author Libardo, Julio
 */
public class BrasilDeliveryPlugin implements IDeliveryPlugin {

    /**
     * Calcular el costo de envío de un producto de la tienda enviado dentro de
     * México.
     *
     */
    public double calculateCost(Delivery delivery) {

        Product product = delivery.getProduct();
        double weight = product.getWeight();
        double distance = delivery.getDistance();
        double cost;

        if (weight > 5) { 
            //Costo mayor a 5
            cost = 2 * distance;
        } else if (weight > 1) {
            // Costo inferior a 5 kg y superior a 1 kg
            cost = 1.5 * distance;
        } else {
            // Costo inferior a 1 kg
            cost = 50;
        }
        return cost;
    }
}
