package com.example.ITSSBE;

import com.example.ITSSBE.converter.EquipmentConverter;
import com.example.ITSSBE.converter.FeedBackConverter;
import com.example.ITSSBE.dto.EquipmentDTO;
import com.example.ITSSBE.dto.FeedBackDTO;
import com.example.ITSSBE.entity.EpCategory;
import com.example.ITSSBE.entity.Equipment;
import com.example.ITSSBE.entity.FeedBack;
import com.example.ITSSBE.entity.Room;
import com.example.ITSSBE.repository.IEpCategoryRepo;
import com.example.ITSSBE.repository.IEquipmentRepo;
import com.example.ITSSBE.repository.IFeedBackRepo;
import com.example.ITSSBE.repository.IRoomRepo;
import com.example.ITSSBE.service.impl.EquipmentService;
import com.example.ITSSBE.service.impl.FeedBackService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;

@SpringBootTest
class ItssbeApplicationTests {

	@Test
	void contextLoads() {
	}

	@Mock
	private IEquipmentRepo equipmentRepo;

	@Mock
	private IRoomRepo roomRepo;

	@Mock
	private IEpCategoryRepo epCategoryRepo;

	@Mock
	private IFeedBackRepo feedBackRepo;

	private EquipmentConverter equipmentConverter;
	private EquipmentService equipmentService;
	private FeedBackConverter feedBackConverter;
	private FeedBackService feedBackService;

	@BeforeEach
	public void setup() {
		MockitoAnnotations.openMocks(this);
		equipmentConverter = new EquipmentConverter();
		equipmentService = new EquipmentService();
		feedBackConverter = new FeedBackConverter();
		feedBackService = new FeedBackService();
	}

	@Test
	public void testGetAllEquipments() {
		// Arrange
		Equipment equipment1 = new Equipment();
		equipment1.setId(1);
		equipment1.setName("Equipment 1");

		Equipment equipment2 = new Equipment();
		equipment2.setId(2);
		equipment2.setName("Equipment 2");

		List<Equipment> mockEquipments = Arrays.asList(equipment1, equipment2);

		when(equipmentRepo.findAll()).thenReturn(mockEquipments);

		// Act
		List<EquipmentDTO> result = equipmentService.getAllEquipments();

		// Assert
		Assertions.assertEquals(2, result.size());
		Assertions.assertEquals("Equipment 1", result.get(0).getName());
		Assertions.assertEquals("Equipment 2", result.get(1).getName());

		verify(equipmentRepo, times(1)).findAll();
	}

	@Test
	public void testGetAllEquipmentsWhenEmpty() {
		// Arrange
		when(equipmentRepo.findAll()).thenReturn(Collections.emptyList());

		// Act
		List<EquipmentDTO> result = equipmentService.getAllEquipments();

		// Assert
		Assertions.assertTrue(result.isEmpty());

		verify(equipmentRepo, times(1)).findAll();
	}

	@Test
	public void testGetAllEquipmentsWithConversion() {
		// Arrange
		Equipment equipment1 = new Equipment();
		equipment1.setId(1);
		equipment1.setName("Equipment 1");

		Equipment equipment2 = new Equipment();
		equipment2.setId(2);
		equipment2.setName("Equipment 2");

		List<Equipment> mockEquipments = Arrays.asList(equipment1, equipment2);

		when(equipmentRepo.findAll()).thenReturn(mockEquipments);

		// Act
		List<EquipmentDTO> result = equipmentService.getAllEquipments();

		// Assert
		Assertions.assertEquals(2, result.size());
		Assertions.assertEquals("Equipment 1", result.get(0).getName());
		Assertions.assertEquals("Equipment 2", result.get(1).getName());

		verify(equipmentRepo, times(1)).findAll();
		verify(equipmentConverter, times(2)).toDTO(any(Equipment.class));
	}

	@Test
	public void testGetEquipmentByIdWhenFound() {
		// Arrange
		int equipmentId = 1;

		Equipment equipment = new Equipment();
		equipment.setId(equipmentId);
		equipment.setName("Equipment 1");

		EquipmentDTO expectedDto = new EquipmentDTO();
		expectedDto.setId(equipmentId);
		expectedDto.setName("Equipment 1");

		when(equipmentRepo.findById(equipmentId)).thenReturn(equipment);
		when(equipmentConverter.toDTO(equipment)).thenReturn(expectedDto);

		// Act
		EquipmentDTO result = equipmentService.getEquipment(equipmentId);

		// Assert
		Assertions.assertEquals(expectedDto.getId(), result.getId());
		Assertions.assertEquals(expectedDto.getName(), result.getName());

		verify(equipmentRepo, times(1)).findById(equipmentId);
		verify(equipmentConverter, times(1)).toDTO(equipment);
	}

	@Test
	public void testGetEquipmentByIdWhenNotFound() {
		// Arrange
		int equipmentId = 1;

		when(equipmentRepo.findById(equipmentId)).thenReturn(null);

		// Act
		EquipmentDTO result = equipmentService.getEquipment(equipmentId);

		// Assert
		Assertions.assertNull(result);

		verify(equipmentRepo, times(1)).findById(equipmentId);
		verifyNoMoreInteractions(equipmentConverter);
	}

	@Test
	public void testAddEquipmentWhenCategoryExists() {
		// Arrange
		EquipmentDTO equipmentDTO = new EquipmentDTO();
		equipmentDTO.setCategory_name("Category 1");
		equipmentDTO.setRoom_id(1);

		EpCategory existingCategory = new EpCategory();
		existingCategory.setName("Category 1");

		Room existingRoom = new Room();
		existingRoom.setId(1);

		Equipment equipment = new Equipment();
		equipment.setId(1);
		equipment.setCategory(existingCategory);
		equipment.setRoom(existingRoom);

		when(epCategoryRepo.findByName("Category 1")).thenReturn(existingCategory);
		when(roomRepo.findById(1)).thenReturn(existingRoom);
		when(equipmentRepo.save(any(Equipment.class))).thenReturn(equipment);
		when(equipmentConverter.toDTO(equipment)).thenReturn(equipmentDTO);

		// Act
		EquipmentDTO result = equipmentService.addEquipment(equipmentDTO);

		// Assert
		Assertions.assertNotNull(result);
		Assertions.assertEquals(equipmentDTO, result);

		verify(epCategoryRepo, times(1)).findByName("Category 1");
		verify(roomRepo, times(1)).findById(1);
		verify(equipmentRepo, times(1)).save(any(Equipment.class));
		verify(equipmentConverter, times(1)).toDTO(equipment);
	}

	@Test
	public void testAddEquipmentWhenCategoryDoesNotExist() {
		// Arrange
		EquipmentDTO equipmentDTO = new EquipmentDTO();
		equipmentDTO.setCategory_name("Non-existent Category");
		equipmentDTO.setRoom_id(1);

		when(epCategoryRepo.findByName("Non-existent Category")).thenReturn(null);

		// Act
		EquipmentDTO result = equipmentService.addEquipment(equipmentDTO);

		// Assert
		Assertions.assertNull(result);

		verify(epCategoryRepo, times(1)).findByName("Non-existent Category");
		verifyNoMoreInteractions(roomRepo, equipmentRepo, equipmentConverter);
	}

	@Test
	public void testDeleteEquipment() {
		// Arrange
		int equipmentId = 1;

		Equipment equipment = new Equipment();
		equipment.setId(equipmentId);
		equipment.set_deleted(false);

		when(equipmentRepo.findById(equipmentId)).thenReturn(equipment);

		// Act
		equipmentService.deleteEquipment(equipmentId);

		// Assert
		Assertions.assertTrue(equipment.is_deleted());

		verify(equipmentRepo, times(1)).findById(equipmentId);
	}


	@Test
	public void testDeleteEquipmentNotFound() {
		// Arrange
		int equipmentId = 1;

		when(equipmentRepo.findById(equipmentId)).thenReturn(null);

		// Act
		equipmentService.deleteEquipment(equipmentId);

		// Assert
		// No assertions can be made since equipment is not found

		verify(equipmentRepo, times(1)).findById(equipmentId);
	}


	@Test
	public void testGetAllFeedBack() {
		// Arrange
		FeedBack feedBack1 = new FeedBack();
		feedBack1.setId(1);
		feedBack1.setContent("Feedback 1");

		FeedBack feedBack2 = new FeedBack();
		feedBack2.setId(2);
		feedBack2.setContent("Feedback 2");

		List<FeedBack> mockFeedBacks = Arrays.asList(feedBack1, feedBack2);

		FeedBackDTO feedBackDTO1 = new FeedBackDTO();
		feedBackDTO1.setId(1);
		feedBackDTO1.setContent("Feedback 1");

		FeedBackDTO feedBackDTO2 = new FeedBackDTO();
		feedBackDTO2.setId(2);
		feedBackDTO2.setContent("Feedback 2");

		when(feedBackRepo.findAll()).thenReturn(mockFeedBacks);
		when(feedBackConverter.toDTO(feedBack1)).thenReturn(feedBackDTO1);
		when(feedBackConverter.toDTO(feedBack2)).thenReturn(feedBackDTO2);

		// Act
		List<FeedBackDTO> result = feedBackService.getAllFeedBack();

		// Assert
		Assertions.assertEquals(2, result.size());
		Assertions.assertEquals(feedBackDTO1, result.get(0));
		Assertions.assertEquals(feedBackDTO2, result.get(1));

		verify(feedBackRepo, times(1)).findAll();
		verify(feedBackConverter, times(1)).toDTO(feedBack1);
		verify(feedBackConverter, times(1)).toDTO(feedBack2);
	}


}
