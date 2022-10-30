package telran.java2022.student.dao;

//@Repository
//public class StudentRepositoryImpl implements StudentRepository {

//    Map<Integer, Student> students = new ConcurrentHashMap<>();
//
//    @Override
//    public Student save(Student student) {
//        students.put(student.getId(), student);
//        return student;
//    }
//
//    @Override
//    public Optional<Student> findById(int id) {
//        return Optional.ofNullable(students.get(id));
//    }
//
//    @Override
//    public void deleteById(int id) {
//        students.remove(id);
//
//    }

//    @Override
//    public void updateStudent(Integer id, Student student) {
//        students.put(id, student);
//    }
//
//    @Override
//    public void addScore(Integer id, Student student) {
//        students.put(id, student);
//    }
//
//    @Override
//    public List<Student> findStudentsByName(String name) {
//        List<Student> studentList = new ArrayList<>();
//        for (Map.Entry<Integer, Student> studentEntry : students.entrySet()) {
//            if (studentEntry.getValue().getName().equals(name)) {
//                studentList.add(studentEntry.getValue());
//            }
//        }
//        return studentList;
//    }
//
//    @Override
//    public Long studentsQuantity(List<String> names) {
//        Long amount = 0L;
//        for (String name : names) {
//            List<Student> studentList = findStudentsByName(name);
//            amount += (long) studentList.size();
//        }
//        return amount;
//    }
//
//    @Override
//    public List<Student> findStudentsByScore(String exam, Integer score) {
//        List<Student> studentList = new ArrayList<>();
//        for (Map.Entry<Integer, Student> studentEntry : students.entrySet()) {
//            if (studentEntry.getValue().getScores().get(exam) != null &&
//                    studentEntry.getValue().getScores().get(exam) >= score) {
//                studentList.add(studentEntry.getValue());
//            }
//
//        }
//
//        return studentList;
//    }
//
//    @Override
//    public Iterable<Student> findAll() {
//        return students.values().stream().collect(Collectors.toList());
//    }




//}
