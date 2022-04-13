package nsutils;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;

class NextStepRandomsTest {

    @RepeatedTest(3)
    void pickNumberInRange() {
        final int result = Randoms.pickNumberInRange(1, 3);
        assertThat(result >= 1).isTrue();
        assertThat(result <= 3).isTrue();
    }

    @RepeatedTest(3)
    void pickNumberInList() {
        final int result = Randoms.pickNumberInList(Arrays.asList(1, 2, 3));
        assertThat(result >= 1).isTrue();
        assertThat(result <= 3).isTrue();
    }

    @RepeatedTest(3)
    void pickUniqueNumbersInRange() {
        final List<Integer> result = Randoms.pickUniqueNumbersInRange(1, 3, 2);
        assertThat(result.size()).isEqualTo(2);
    }

    @Test
    void temp() {
        final MyObject myObject1 = new MyObject(1);
        final MyObject myObject2 = new MyObject(1);

        assertThat(myObject1 == myObject2).isFalse();
        assertThat(myObject1.equals(myObject2)).isTrue();
    }

    static class MyObject {

        private final int value;

        public MyObject(final int value) {
            this.value = value;
        }

        @Override
        public boolean equals(final Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            final MyObject myObject = (MyObject) o;
            return value == myObject.value;
        }

        @Override
        public int hashCode() {
            return Objects.hash(value);
        }
    }

}
