package com.ayoub.avions;

import com.ayoub.avions.entities.Avion;
import com.ayoub.avions.repos.AvionRepository;
import com.ayoub.avions.service.AvionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import java.util.Date;
import java.util.List;

@SpringBootTest
class AvionsApplicationTests {

	@Autowired
	private AvionRepository avionRepository;
	@Autowired
	private AvionService avionService;
	@Test
	public void testCreateAvion() {
		Avion av = new Avion("TU 216",2200.500,new Date());
		avionRepository.save(av);
	}
	@Test
	public void testFindAvion()
	{
		Avion a = avionRepository.findById(2L).get();
		System.out.println(a);
	}
	@Test
	public void testUpdateAvion()
	{
		Avion a = avionRepository.findById(1L).get();
		a.setPrixAvion(1000.0);
		avionRepository.save(a);
	}
	@Test
	public void testDeleteAvion()
	{
		avionRepository.deleteById(1L);
	}
	@Test
	public void testListerTousAvions()
	{
		List<Avion> av = avionRepository.findAll();
		for (Avion a : av)
		{
			System.out.println(a);
		}
	}
	@Test
	public void testFindByNomAvionContains()
	{
		Page<Avion> prods = avionService.getAllAvionsParPage(0,2);
		System.out.println(prods.getSize());
		System.out.println(prods.getTotalElements());
		System.out.println(prods.getTotalPages());
		prods.getContent().forEach(p -> {System.out.println(p.toString());
		});
	}

}
