package com.jtudy.cdi2;

import javax.enterprise.event.Event;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.inject.Named;

import com.jtudy.cdi2.custom.CloseEvent;
import com.jtudy.cdi2.custom.OpenEvent;
import com.jtudy.cdi2.model.Car;

@Named
public class CarService {

	@Inject @OpenEvent Event<Car> openEvent;
    @Inject @CloseEvent Event<Car> closeEvent;
    
    public void open(Car car) {
    	openEvent.fire(car);
    }
    
    public void close(Car car) {
    	closeEvent.fire(car);
    }
    
    public void onOpen(@Observes @OpenEvent Car car) {
    	System.out.println(car.getName() + " is opened.");
    }
    
    public void onClose(@Observes @CloseEvent Car car) {
    	System.out.println(car.getName() + " is closed.");
    }
}
