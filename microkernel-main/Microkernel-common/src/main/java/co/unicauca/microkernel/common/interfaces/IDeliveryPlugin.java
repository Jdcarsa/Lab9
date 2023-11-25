package co.unicauca.microkernel.common.interfaces;

import co.unicauca.microkernel.common.entities.Delivery;

public interface IDeliveryPlugin {


    double calculateCost(Delivery delivery);

}
