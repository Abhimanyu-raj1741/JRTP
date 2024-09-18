package in.ashokit;

import org.junit.jupiter.api.Test;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Monoflux {
	   
		
		//@Test
		public void testMono() {
		
			// publisher  => publishes the content 
		   Mono<String> mono  = Mono.just("Abhimanyu").log();
		

		   // subscriber => Will consume data from publisher 
	       mono.subscribe(System.out::println);
		
		}
		@Test
		public void testFlux() {

			// publisher  => publishes the content 
			Flux<String > flux = Flux.just("java" , "programming","language").log();
			
			// subscriber => Will consume data from publisher
			flux.subscribe(System.out::println);
			
		}
		
	
}
