package tn.esprit.spring.Service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.Entity.DeliveryMan;
import tn.esprit.spring.Entity.OrderDelivery;
import tn.esprit.spring.Entity.Role;
import tn.esprit.spring.Repository.DeliveryManRepository;
import tn.esprit.spring.Repository.OrderDeliveryRepository;
import tn.esprit.spring.Repository.UserRepository;

@Service
public class DeliveryManService implements ImpDeliveryManService {

	@Autowired
	private DeliveryManRepository deliveryManRepository;
	@Autowired
	private OrderDeliveryRepository orderDeliveryRepository;
	@Autowired
	private UserRepository userRepository;
	// Return Single DeliveryMan
	@Override
	public DeliveryMan getDeliveryMan(int id) {
		DeliveryMan deliveryMan = deliveryManRepository.findById(id).get();
		return deliveryMan;
	}

	// Save the deliveryMan
	@Override
	public void saveDeliveryMan(DeliveryMan deliveryMan) {
		deliveryMan.setRole(Role.DELIVERYMANN);
		deliveryMan.setPoint(0);
		deliveryMan.setDisponibility(true);
		deliveryManRepository.save(deliveryMan);
	}

	// update the deliveryMan
	@Override
	public void updateDeliveryMan(DeliveryMan deliveryMan) {
		deliveryMan.setRole(Role.DELIVERYMANN);
		deliveryManRepository.save(deliveryMan);
	}

	// Remove the DeliveryMan
	@Override
	public void deleteDeliveryMan(int id) {
		deliveryManRepository.deleteById(id);
	}

	@Override
	public int nearestMan (int clientId) {
		List<DeliveryMan> deliveryManList =getAllTheDeliveryMans();
		int closestDeliveryManId = deliveryManList.get(0).getId();		
		double closetDistance=distance( closestDeliveryManId,clientId);
		for (int i = 1; i <= deliveryManList.size() - 1; i++) {
			if (closetDistance > distance(deliveryManList.get(i).getId(),clientId)) {
				closestDeliveryManId = deliveryManList.get(i).getId();
				
			}
		}
		return closestDeliveryManId; 
	}


	// Affect Order to DeliveryMan
	@Override
	public void affectDeliveryManToOrder(int deliveryManId, int orderId) {
		DeliveryMan d = deliveryManRepository.findById(deliveryManId).get();
		OrderDelivery e = orderDeliveryRepository.findById(orderId).get() ;
		e.setDeliveryMan(d);
		d.setDisponibility(false);
		d.setPoint(d.getPoint() + 1);
		orderDeliveryRepository.save(e);
		deliveryManRepository.save(d);
 	}

	// DeliveryMan of the month

	@Override
	public DeliveryMan DeliveryManOfTheMounth() {
		List<DeliveryMan> deliveryManList = getAllTheDeliveryMans();
		DeliveryMan manOfTheMonth = deliveryManList.get(0);
		for (int i = 0; i < deliveryManList.size() - 1; i++) {
			if (deliveryManList.get(i).getPoint() <= deliveryManList.get(i + 1).getPoint()) {
				manOfTheMonth = deliveryManList.get(i + 1);
			}
		}

		return manOfTheMonth;
	}

	// Return All the deliveryMans
	@Override
	public List<DeliveryMan> getAllTheDeliveryMans() {
		List<DeliveryMan> deliveryManList = new ArrayList<>();
		deliveryManRepository.findAll().forEach(deliveryManList::add);
		return deliveryManList;
	}

	@Override
	public double haversin(double val) {
		return Math.pow(Math.sin(val / 2), 2);
	}

	// distance using haversine
	@Override
	public double distance(int delvmanId, int clientId) {
		final int EARTH_RADIUS = 6371;
		double startLat = deliveryManRepository.findById(delvmanId).get().getLatitude();
		double startLong = deliveryManRepository.findById(delvmanId).get().getLongitude();
		double endLat = userRepository.findById(clientId).get().getLatitude();
		double endLong = userRepository.findById(clientId).get().getLongitude();

		double dLat = Math.toRadians((endLat - startLat));
		double dLong = Math.toRadians((endLong - startLong));

		startLat = Math.toRadians(startLat);
		endLat = Math.toRadians(endLat);
		double a = haversin(dLat) + Math.cos(startLat) * Math.cos(endLat) * haversin(dLong);
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

		return EARTH_RADIUS * c;
	}

}