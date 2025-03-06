package com.ohgiraffers.level01.basic;

public class ShapeManager {
    private Shape[] shapes = new Shape[10];
    private int index = 0;

    public void addShape(Shape shape) {
        /* 배열에 전달 된 Shape를 추가. 단, 배열의 크기가 부족할 경우 2배로 늘려서 추가. */
        if (index >= shapes.length) {
            // 새로운 배열 생성 (기존 크기의 2배)
            Shape[] newShapes = new Shape[shapes.length * 2];
            // 기존 배열 요소 복사
            System.arraycopy(shapes, 0, newShapes, 0, shapes.length);
            // 배열 교체
            shapes = newShapes;
        }
        // 새로운 요소 추가
        shapes[index] = shape;
        index++;
        }

    public void removeShape(Shape shape) {
        /* 배열에서 전달 된 Shape를 찾아 제거. 단, 제거 된 인덱스가 비어 있지 않도록 뒤에 있는 객체를 앞으로 당김. */
        int size = -1;
        for(int i=0; i<index; i++){
            if(shapes[i].equals(shape)){
                size = i;
                break;
            }
        }
        if (index == -1) {
            System.out.println("해당 Shape가 배열에 존재하지 않습니다.");
            return;
        }
        for(int i = size; i<index-1; i++){
            shapes[i] = shapes[i + 1];
        }
        shapes[index - 1] = null;
        index--;
    }

    public void printAllShapes() {
        /* 배열에 저장 된 모든 도형의 이름, 넓이, 둘레를 출력 */
        for(int i=0; i<index; i++){
            System.out.print("Shape : "+shapes[i].getClass().getSimpleName());
            System.out.println();
            System.out.print("Area : "+shapes[i].calculateArea());
            System.out.println();
            System.out.print("Perimeter : "+shapes[i].calculatePerimeter());
            System.out.println();
        }
    }

    public double getTotalArea() {
        /* 배열에 저장 된 모든 도형의 넓이를 더해서 반환 */
        double sum = 0;
        for (int i = 0; i < index; i++) {
            sum += shapes[i].calculateArea();
        }
        return sum;
    }

    public double getTotalPerimeter() {
        /* 배열에 저장 된 모든 도형의 둘레를 더해서 반환 */
        double sum = 0;
        for (int i = 0; i < index; i++) {
            sum += shapes[i].calculatePerimeter();
        }
        return sum;
    }
}
