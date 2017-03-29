package by.vdoroshenko.objects;

/**
 * Created by viktoriyadoroshenko on 3/29/17.
 */
public enum Values {

    ID {
        @Override
        public String toString() {
            return "id";
        }
    },
    NAME {
        @Override
        public String toString() {
            return "Name";
        }
    },
    TYPE {
        @Override
        public String toString() {
            return "Type";
        }
    },
    SPEED {
        @Override
        public String toString() {
            return "Speed";
        }
    },
    CAPACITY {
        @Override
        public String toString() {
            return "Capacity";
        }
    },
    LENGTH {
        @Override
        public String toString() {
            return "Length";
        }
    },
    OBJECT {
        @Override
        public String toString() {
            return "Airplane";
        }
    }

}
