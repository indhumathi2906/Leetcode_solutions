class Solution {
        public String dayOfTheWeek(int day, int month, int year) {
                String[] week = {
                            "Sunday", "Monday", "Tuesday",
                                        "Wednesday", "Thursday", "Friday", "Saturday"
                                                };

                                                        int[] daysInMonth = {
                                                                    31,28,31,30,31,30,31,31,30,31,30,31
                                                                            };

                                                                                    int totalDays = 0;

                                                                                            // Count days for complete years
                                                                                                    for (int y = 1971; y < year; y++) {
                                                                                                                totalDays += isLeap(y) ? 366 : 365;
                                                                                                                        }

                                                                                                                                // Count days for complete months
                                                                                                                                        for (int m = 1; m < month; m++) {
                                                                                                                                                    totalDays += daysInMonth[m - 1];

                                                                                                                                                                if (m == 2 && isLeap(year)) {
                                                                                                                                                                                totalDays++;
                                                                                                                                                                                            }
                                                                                                                                                                                                    }

                                                                                                                                                                                                            // Count days in current month
                                                                                                                                                                                                                    totalDays += day - 1;

                                                                                                                                                                                                                            // January 1, 1971 was Friday
                                                                                                                                                                                                                                    return week[(5 + totalDays) % 7];
                                                                                                                                                                                                                                        }

                                                                                                                                                                                                                                            private boolean isLeap(int year) {
                                                                                                                                                                                                                                                    return (year % 400 == 0) || (year % 4 == 0 && year % 100 != 0);
                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                        }
