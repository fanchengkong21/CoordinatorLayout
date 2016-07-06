## CoordinatorLayout ##

- 它是用来组织它的子views之间协作的一个父view

- CoordinatorLayout默认情况下可理解是一个FrameLayout，它的布局方式默认是一层一层叠上去

- 那么，CoordinatorLayout的神奇之处就在于Behavior对象

**小程序的实现效果:蓝色的矩形是我们一个普通View，黄色的Hello是一个Button。我们水平拖动蓝色矩形时，黄色Button查着与蓝色矩形相反方向移动；竖直移动蓝色矩形时，黄色也跟着竖直。简而言之：它们在竖直方向同步移动，在水平方向相反。**
