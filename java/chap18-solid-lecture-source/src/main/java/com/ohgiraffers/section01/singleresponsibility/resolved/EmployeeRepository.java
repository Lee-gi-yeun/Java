package com.ohgiraffers.section01.singleresponsibility.resolved;

public class EmployeeRepository {
    public void sava(Employee employee) {
        validateEmployeeDate(employee);
        System.out.println(employee.getName() + "의 정보를 데이터베이스에 저장했습니다.");
    }

    // validation 체크용 메소드는 private으로 작성하고 굳이 외부에 노출하지 않는다
    private void validateEmployeeDate(Employee employee) {
        if(employee == null)
            throw new IllegalArgumentException("직원 정보가 null일 수 없습니다");

        if(employee.getName() == null || employee.getName().trim().isEmpty())
            throw new IllegalArgumentException("직원 이름은 필수 입니다");
    }
}
