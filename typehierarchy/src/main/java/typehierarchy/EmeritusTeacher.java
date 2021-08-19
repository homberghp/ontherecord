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

/**
 *
 * @author Pieter van den Hombergh {@code <pieter.van.den.hombergh@gmail.com>}
 */
public interface EmeritusTeacher extends Tutor {

    int retirementYear();

    static EmeritusTeacher of(Tutor aTutor, int retirementYear) {
        return new EmeritusTeacherRecord( aTutor, retirementYear );
    }

    record EmeritusTeacherRecord(Tutor tutor, int retirementYear) implements EmeritusTeacher{

        @Override
        public String course() {
            return tutor.course();

        }

        @Override
        public String name() {
            return tutor.name();
        }

        @Override
        public long digid() {
            return tutor.digid();
        }

    }
}