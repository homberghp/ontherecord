/*
 * Copyright 2021 Pieter van den Hombergh {@code <pieter.van.den.hombergh@gmail.com>}.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package typeheirarchy;

/**
 *
 * @author Pieter van den Hombergh {@code <pieter.van.den.hombergh@gmail.com>}
 */
public interface Alumnus extends Student {
    
    Student student();
    int graduationYear();
    
    static Alumnus of(Student aStudent, int year){
        return new AlumnusRecord(  aStudent,year);
    } 
    
    record AlumnusRecord(String name, long digid, String school, int graduationYear) implements Alumnus{

        private AlumnusRecord(Student aStudent, int year) {
            this(aStudent.name(),aStudent.digid(),aStudent.school(),year);

        }

        @Override
        public Student student() {
            return Student.of(name(),digid(),school());
        }
    }
}
