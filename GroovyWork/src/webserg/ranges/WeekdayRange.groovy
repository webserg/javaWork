package webserg.ranges

/**
 * The Weekday class is like an inner class to the script.
 *  For loops and conditionals are not objects, cannot be reused, and cannot be
passed around, but ranges can. Ranges let you focus on what the code does, rather
than how it does it.
 */
class Weekday implements Comparable {
  static final DAYS = [
          'Sun', 'Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat'
  ]
  private int index = 0

  Weekday(String day) {
    index = DAYS.indexOf(day)
  }

  Weekday next() {
    return new Weekday(DAYS[(index + 1) % DAYS.size()])
  }

  Weekday previous() {
    return new Weekday(DAYS[index - 1])
  }

  int compareTo(Object other) {
    return this.index <=> other.index
  }

  String toString() {
    return DAYS[index]
  }
}

def mon = new Weekday('Mon')
def fri = new Weekday('Fri')
def worklog = ''
for (day in mon..fri) {
  worklog += day.toString() + ' '
}
assert worklog == 'Mon Tue Wed Thu Fri '

