# PullUpToLoadMoreInfo
Android实现类似“淘宝、天猫”产品详情界面，继续向上拖动查看更多详情的控件

原理：
1、“产品详情”和“更多详情”各由一个ScrollView实现。
2、自定义ScorllView，继承系统ScrollView，实现判断第一个页面是否滑动底部，以及第二个页面是否滑到顶部。
3、自定义View，继承ViewGroup，处理事件分发：
a、如果是向上滑动，并且滑动距离>=我们定义的距离distance，就调用ScrollView的scrollBy()方法向上滑动，使第二个页面滑到顶部；
b、如果是向下滑动，并且滑动距离>=distance，同样调用ScorllView的scrollBy()方法向下滑动，使第一个页面滑动界面顶部。
