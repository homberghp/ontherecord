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
package typehierarchy;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Pieter van den Hombergh {@code <pieter.van.den.hombergh@gmail.com>}
 */
public class School {

    private final String fontys;
    final List<Student> students = new ArrayList<>();
    final List<Tutor> tutors = new ArrayList<>();
    final List<StudentAssistant> assistants = new ArrayList<>();
    final List<EmeritusTeacher> emiritates = new ArrayList<>();

    public School(String fontys) {
        this.fontys = fontys;
    }

    public static void main(String[] args) {
        School fontys = new School( "fontys" );
        Tutor homb02 = Tutor.of( "Pieter van den Hombergh", 879417, "JAVA" );
        fontys.add( homb02 );
        fontys.add( EmeritusTeacher.of( homb02, 2021 ) );
        fontys.add( Student.of( "Pietje Puk", 82452102, "fontys" ) );
        fontys.add( StudentAssistant.of( "Barbara Feldon", 81302062, "fontys", "JAVA" ) );

        System.out.println( "fontys = " + fontys );
    }

    public void add(Tutor aTutor) {
        tutors.add( aTutor );
    }

    public void add(Student aStudent) {
        students.add( aStudent );
    }

    public void add(StudentAssistant assist) {
        students.add( assist );
        tutors.add( assist );
        assistants.add( assist );
    }

    public void add(EmeritusTeacher anOldTeacher) {
        emiritates.add( anOldTeacher );
    }

    @Override
    public String toString() {
        return "School{\n" + " name=" + fontys + ",\n students=" + students + ",\n tutors=" + tutors + ",\n assistants=" + assistants + ",\n emiritates=" + emiritates + "\n}";
    }

}
