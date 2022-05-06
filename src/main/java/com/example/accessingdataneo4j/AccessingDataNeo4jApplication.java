
package com.example.accessingdataneo4j;

import com.example.accessingdataneo4j.model.domain.st.Actor;
import com.example.accessingdataneo4j.model.domain.st.Movie;
import com.example.accessingdataneo4j.model.domain.st.Person;
import com.example.accessingdataneo4j.model.repository.st.MovieRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.neo4j.core.Neo4jTemplate;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;
import java.util.ArrayList;

@SpringBootApplication
@EnableNeo4jRepositories
@EnableTransactionManagement
public class AccessingDataNeo4jApplication {

	@Resource
	Neo4jTemplate neo4jTemplate;

	private final static Logger log = LoggerFactory.getLogger(AccessingDataNeo4jApplication.class);


	public static void main(String[] args) throws Exception {
		SpringApplication.run(AccessingDataNeo4jApplication.class, args);
		System.exit(0);
	}

	@Bean
	CommandLineRunner demo(MovieRepository movieRepository) {
		return args -> {

		Movie movie = new Movie();
		movie.setTitle("泰坦尼克号");
		movie.setDescription("海难，爱情");
		Person personLi = new Person();
		personLi.setBorn(1992);
		personLi.setName("莱昂拉多");

		Person personK = new Person();
		personK.setBorn(1995);
		personK.setName("凯特温斯莱特");

		Actor actor1 = new Actor();
		actor1.setPerson(personLi);
		actor1.setRoles(new ArrayList<String>() {{
			add("主演");
			add("男主角");
		}});
		Actor actor2 = new Actor();
		actor2.setPerson(personK);
		actor2.setRoles(new ArrayList<String>() {{
			add("主演");
			add("女主角");
		}});

		movie.getActors().add(actor1);
		movie.getActors().add(actor2);


		Person personJ = new Person();
		personJ.setName("詹姆斯卡梅隆");
		personJ.setBorn(1965);
		personJ.getReviewed().add(movie);

		movie.getDirectors().add(personJ);

		movie.getDirectors().add(personJ);

		movieRepository.save(movie);
	};
}

//	@Bean
//	CommandLineRunner demo(EBOMPartRepository ebomPartRepository){
//		return args -> {
////			EBOMPart pc = EBOMPart.builder().itemCode("pc").name("办公电脑").version("A").asmRelations(new HashSet<>()).build();
////
////			EBOMPart screen = EBOMPart.builder().itemCode("screen").name("显示器").version("A").asmRelations(new HashSet<>()).build();
////
////			EBOMPart mainMachine = EBOMPart.builder().itemCode("mainMachine").name("主机").version("A").asmRelations(new HashSet<>()).build();
////
////			EBOMPart cpu = EBOMPart.builder().itemCode("cpu").name("cpu").version("A").asmRelations(new HashSet<>()).build();
////
////			EBOMPart gpu = EBOMPart.builder().itemCode("gpu").name("gpu").version("A").asmRelations(new HashSet<>()).build();
////
////
////			EBOMPart ram = EBOMPart.builder().itemCode("ram").name("ram").version("A").asmRelations(new HashSet<>()).build();
////
////			//装配
////			mainMachine.getAsmRelations().add(EBOMAsmRelation.builder().quantity(2L).assembledPart(cpu).build());
////			mainMachine.getAsmRelations().add(EBOMAsmRelation.builder().quantity(4L).assembledPart(gpu).build());
////			mainMachine.getAsmRelations().add(EBOMAsmRelation.builder().quantity(16L).assembledPart(ram).build());
////
////			pc.getAsmRelations().add(EBOMAsmRelation.builder().quantity(1L).assembledPart(screen).build());
////			pc.getAsmRelations().add(EBOMAsmRelation.builder().quantity(1L).assembledPart(mainMachine).build());
////
////
////			EBOMPart pcPart = ebomPartRepository.save(pc);
//			EBOMPart pcPart = ebomPartRepository.findById("pc").get();
//			System.out.println("######################");
//		};
//	}



//	private EBOMPart getByItemCode(String itemCode){
//		String cql = "match(a:EBOMPart)<-->(b) where a.itemCode = \"node_67\" return a,b";
//
//	}

	/*@Bean
	CommandLineRunner demo(EBOMPartRepository ebomPartRepository){
		return args -> {

			Map<Integer,EBOMPart> partsMap = new HashMap<>();
			for (int i = 0; i < 10000; i++) {
				//先
				partsMap.put(i, EBOMPart.builder().itemCode("node_"+i).name("node_"+i).version("A").asmRelations(new HashSet<>()).build());

			}
			//添加关系
			for (int i = 0; i < 10000; i++) {
				if((2*i+2)>(10000-1)){
					break;
				}
				partsMap.get(i).getAsmRelations().add(EBOMAsmRelation.builder().quantity(2L).assembledPart(partsMap.get(2*i+1)).build());
				partsMap.get(i).getAsmRelations().add(EBOMAsmRelation.builder().quantity(2L).assembledPart(partsMap.get(2*i+2)).build());
			}
//
			EBOMPart head = ebomPartRepository.save(partsMap.get(0));
//			List<EBOMPart> node_67 = ebomPartRepository.queryByItemCode("node_67");
//			List<EBOMPart> children = ebomPartRepository.queryChildrenByItemCode("node_67");
//			List<EBOMPart> children1 = ebomPartRepository.queryChildrenWithRelationByItemCode("node_67");
//			List<PathValue> pathValues = ebomPartRepository.queryPathByItemCode("node_67");
//			Path segments = pathValues.get(0).asPath();
//			Node start = segments.start();
//			pathValues.get(0).asPath().start().get("name")


//			EBOMPart pc = EBOMPart.builder().itemCode("pc").name("办公电脑").version("A").asmRelations(new HashSet<>()).build();
//
//			EBOMPart screen = EBOMPart.builder().itemCode("screen").name("显示器").version("A").asmRelations(new HashSet<>()).build();
//
//			EBOMPart mainMachine = EBOMPart.builder().itemCode("mainMachine").name("主机").version("A").asmRelations(new HashSet<>()).build();
//
//			EBOMPart cpu = EBOMPart.builder().itemCode("cpu").name("cpu").version("A").asmRelations(new HashSet<>()).build();
//
//			EBOMPart gpu = EBOMPart.builder().itemCode("gpu").name("gpu").version("A").asmRelations(new HashSet<>()).build();
//
//
//			EBOMPart ram = EBOMPart.builder().itemCode("ram").name("ram").version("A").asmRelations(new HashSet<>()).build();
//
//			//装配
//			mainMachine.getAsmRelations().add(EBOMAsmRelation.builder().quantity(2L).assembledPart(cpu).build());
//			mainMachine.getAsmRelations().add(EBOMAsmRelation.builder().quantity(4L).assembledPart(gpu).build());
//			mainMachine.getAsmRelations().add(EBOMAsmRelation.builder().quantity(16L).assembledPart(ram).build());
//
//			pc.getAsmRelations().add(EBOMAsmRelation.builder().quantity(1L).assembledPart(screen).build());
//			pc.getAsmRelations().add(EBOMAsmRelation.builder().quantity(1L).assembledPart(mainMachine).build());
//
//
//			EBOMPart pcPart = ebomPartRepository.save(pc);
//			EBOMPart pcPart = ebomPartRepository.findById("pc").get();
			System.out.println("######################");
		};
	}*/
//	@Bean
//	CommandLineRunner demo(PartRepository partRepository){
//		return args -> {
//
////			Part a = new Part();
////			a.setLevel(1L);
////			a.setType("零组件a");
////			a.setDescription("a");
////
////			Part b = new Part();
////			b.setLevel(2L);
////			b.setType("零组件b");
////			b.setDescription("b");
////
////			EBOM ebomb = new EBOM();
////			ebomb.setPart(b);
////			ebomb.setQuantity(10L);
////
////
////			Part c = new Part();
////			c.setLevel(2L);
////			c.setType("零组件c");
////			c.setDescription("c");
////
////			EBOM ebomc = new EBOM();
////			ebomc.setPart(c);
////			ebomc.setQuantity(20L);
////
////
////			a.getEboms().add(ebomb);
////			a.getEboms().add(ebomc);
////
////
////			partRepository.save(a);
//
//
//			Optional<Part> cmpD = partRepository.findById(19L);
//
//
//			Optional<Part> cmpE = partRepository.findById(20L);
//
//			if (cmpE.isPresent()){
//				if (cmpD.isPresent()){
//					System.out.println(cmpD.get().getEboms());
//					EBOM x = new EBOM();
//					x.setPart(cmpD.get());
//					x.setQuantity(5L);
//					cmpE.get().getEboms().add(x);
//
//					partRepository.save(cmpE.get());
//
//				}
//
//			}
//
//		};
//	}



//	@Bean
//	CommandLineRunner demo(BookRepository bookRepository){
//		return args -> {
//			List<BookPO> books = new ArrayList<>();
//
//			Set<Long> ids = new HashSet<>();
//			for (int i = 0; i < 1001; i++) {
//				BookPO bookPO = new BookPO();
//				bookPO.setName("book"+i);
//				bookPO.setType("type"+i);
//
//				books.add(bookPO);
//				ids.add((long) i);
//			}
//			bookRepository.saveAll(books);
////
////
////			List<BookPO> all = bookRepository.findAll();
////			System.out.println(all.size());
////			Set<Long> ids = new HashSet<>();
////			for (int i = 0; i < 1001; i++) {
////
////				ids.add((long) i);
////			}
//
//			try {
//				List<BookPO> all = bookRepository.getAllByIdIn(ids);
//				System.out.println(all.size());
//			}catch (Exception e){
//				System.out.println(e.getMessage());
//
//			}
//			bookRepository.deleteAllByIdIn(ids);
//
//
////			List<BookPO> all = bookRepository.getAllByNameIsNotNull();
////			System.out.println(all.size());
//
//
//		};
//
//
//	}


//	@Bean
//	CommandLineRunner demo(PersonRepository personRepository) {
//		return args -> {
//
//			personRepository.deleteAll();
//
//			Person greg = new Person("Greg");
//			Person roy = new Person("Roy");
//			Person craig = new Person("Craig");
//
//			List<Person> team = Arrays.asList(greg, roy, craig);
//
//			log.info("Before linking up with Neo4j...");
//
//			team.stream().forEach(person -> log.info("\t" + person.toString()));
//
//			personRepository.save(greg);
//			personRepository.save(roy);
//			personRepository.save(craig);
//
//			greg = personRepository.findByName(greg.getName());
//			greg.worksWith(roy);
//			greg.worksWith(craig);
//			personRepository.save(greg);
//
//			roy = personRepository.findByName(roy.getName());
//			roy.worksWith(craig);
//			// We already know that roy works with greg
//			personRepository.save(roy);
//
//			// We already know craig works with roy and greg
//
//			log.info("Lookup each person by name...");
//			team.stream().forEach(person -> log.info(
//					"\t" + personRepository.findByName(person.getName()).toString()));
//
//			List<Person> teammates = personRepository.findByTeammatesName(greg.getName());
//			log.info("The following have Greg as a teammate...");
//			teammates.stream().forEach(person -> log.info("\t" + person.getName()));
//		};
//	}

}
