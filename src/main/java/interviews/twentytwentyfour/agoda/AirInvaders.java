package interviews.twentytwentyfour.agoda;

public class AirInvaders {
    /*
    * Problem statement: A video game developer is creating a game involving enemy aircraft. In the game, each plane
    * has a starting position above ground level and a speed at which it is descending. The player character has a gun
    * that can shoot one aircraft during each second. The game ends when a plane is allowed to land. Determine
    * the max no. of planes that can be prevented from landing.
    *
    * Input 1: height:{1,3,5,4,8} , descent rate:{1,2,2,1,2}
    * Output 1: 4
    *
    * Input 2: height:{4,2,2,1} , descent rate:{1,2,3,1}
     * Output 2: 2
     *
     * Input 1: height:{4,5} , descent rate:{1,2}
     * Output 1: 2
    *
    * */

    private int getMaxPlanes(int[] height, int[] descentRate) {
        int max = Integer.MIN_VALUE, n = height.length;
        int countDestroyedPlanes = 0, countLandedPlanes = 0;

        for (int i=0; i<n; i++) {
            max = Math.max(max, height[i]);
        }
        max++;

        while (countLandedPlanes < n) {
            boolean atleastOnePlaneLanded = false;

            for (int i=0; i<n; i++) {
                if (height[i] != max) {
                    height[i] -= descentRate[i];

                    if (height[i] <= 0) {
                        height[i] = max;
                        countLandedPlanes++;
                        atleastOnePlaneLanded = true;
                    }
                }
            }

            if (!atleastOnePlaneLanded) {
                int min_height = Integer.MAX_VALUE, min_height_index = 0;

                for (int i=0; i<n; i++) {
                    if (min_height > height[i]) {
                        min_height = height[i];
                        min_height_index = i;
                    }
                }

                height[min_height_index] = max;
                countLandedPlanes++;
            }

            countDestroyedPlanes++;
        }

        return countDestroyedPlanes;
    }

    public static void main(String[] args) {
        AirInvaders ai = new AirInvaders();
        int[] heightOne = new int[]{1,3,5,4,8};
        int[] descentRateOne = new int[]{1,2,2,1,2};

        System.out.println(ai.getMaxPlanes(heightOne, descentRateOne));

        int[] heightTwo = new int[]{4,2,2,1};
        int[] descentRateTwo = new int[]{1,2,3,1};

        System.out.println(ai.getMaxPlanes(heightTwo, descentRateTwo));

        int[] heightThree = new int[]{4,5};
        int[] descentRateThree = new int[]{1,2};

        System.out.println(ai.getMaxPlanes(heightThree, descentRateThree));
    }
}
