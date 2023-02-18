# Receipt

20220219

1. Menu.java에서 생성자를 선언하지 않아 Cannot resolve constructor 'Menu(MenuRequestDto)' 오류가 발생하였다.
    public Menu(MenuRequestDto requestDto) {
        this.name = requestDto.getName();
        this.price = requestDto.getPrice();
    }
    
2. JPA의 Query Creation 기능 공부하기.
 - 나는 수정 프로퍼티를 쓰지도 않는데 그냥 복붙만 해서 findAllByOrderByModifiedAtDesc를 써서 오류가 발생했다.
 - 그래서 Modified at을 뺀 findAllByOrderByIdDesc()를 써야 한다.

3. @Pathvariable, @RequestParam의 차이.
 - 이건 공부해야 하는 부분이다. PathVariable은 URI의 {} 안 부분을 가져와서 작업한다.
 
4. 더티 체킹 : 더티 체킹(Dirty Checking)은 JPA가 제공하는 기능 중 하나로, 엔티티 객체가 변경되면 트랜잭션을 커밋하는 시점에 자동으로 DB에 반영되는 기능이다.

 - 더티 체킹을 하지 않으면 JPA를 상속한 것 중 save()를 써야 한다.
 
 * 동작방식
  1) 엔티티 객체 조회
  2) 조회한 엔티티 객체 필드값 수정
  3) 트랜잭션 커밋 시, JPA가 변경된 필드값을 감지하고, 해당 필드값이 DB에 반영되도록 자동으로 UPDATE 쿼리를 생성하여 DB에 전달
  
 * 오류가 날 때 주의사항.
1) 엔티티 객체가 영속 상태인지 확인하세요. 만약 영속 상태가 아니라면, 먼저 EntityManager를 사용하여 영속 상태로 만들어 주어야 합니다.
2) update() 메소드가 올바르게 구현되어 있는지 확인하세요. 더티 체킹을 사용하려면, 해당 메소드에서 엔티티 객체의 필드 값을 변경해야 합니다.
   만약 메소드 내부에서 객체를 새로 생성하는 등의 작업을 수행하면, 변경 내용이 영속성 컨텍스트에 반영되지 않아 업데이트가 이루어지지 않습니다.
3) 트랜잭션 처리가 올바르게 되어 있는지 확인하세요. 더티 체킹은 트랜잭션 종료 시에 동작하기 때문에, 트랜잭션 처리가 올바르게 이루어지지 않으면 변경 내용이 커밋되지 않습니다.

 - 더티 체킹을 사용하면 엔티티에 메소드를 선언한다.
     public void update(MenuRequestDto requestDto) {
        this.name = requestDto.getName();
        this.price = requestDto.getPrice();
    }
    
- 위의 소스를 사용하면 바로 저장된다.
