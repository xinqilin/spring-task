# spring-task

### use Lombok
```
-Xbootclasspath/a:lombok.jar
-javaagent:lombok.jar


<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <version>1.18.12</version>
</dependency>

done!
```


### 使用非同步

``@EnableAsync``

Service
``@Async``

### 定時任務


```
@EnableScheduling
@Scheduled

cron屬性
second、minute、hour、day of month (日)、month、day of week(星期幾)
0 * * * * MON-FRI (周一到週五 每分鐘)
* * * * * MON-FRI (周一到週五每秒)
0,1,2,3,4 * * * * * MON-FRI (枚舉，０－４秒)
0-4 * * * * * MON-FRI (直接，０－４秒)
0/4 * * * * * MON-FRI (0秒啟動，每4秒執行一次)


    秒：可出現”, – * /”四個字元，有效範圍為0-59的整數  

    分：可出現”, – * /”四個字元，有效範圍為0-59的整數  

    時：可出現”, – * /”四個字元，有效範圍為0-23的整數  

    每月第幾天：可出現”, – * / ? L W C”八個字元，有效範圍為0-31的整數  

    月：可出現”, – * /”四個字元，有效範圍為1-12的整數或JAN-DEC  

    星期：可出現”, – * / ? L C #”四個字元，有效範圍為0-7的整數或SUN-SAT兩個範圍。0,1 都是星期日 1-6 星期一到六
    
    
    * : 表示匹配該域的任意值，比如在秒*, 就表示每秒都會觸發事件。；

    ? : 只能用在每月第幾天和星期兩個域。表示不指定值，當2個子表示式其中之一被指定了值以後，為了避免衝突，需要將另一個子表示式的值設為“?”；

    – : 表示範圍，例如在分域使用5-20，表示從5分到20分鐘每分鐘觸發一次  

    / : 表示起始時間開始觸發，然後每隔固定時間觸發一次，例如在分域使用5/20,則意味著5分，25分，45分，分別觸發一次.  

    , : 表示列出列舉值。例如：在分域使用5,20，則意味著在5和20分時觸發一次。  

    L : 表示最後，只能出現在星期和每月第幾天域，如果在星期域使用1L,意味著在最後的一個星期日觸發。  

    W : 表示有效工作日(週一到週五),只能出現在每月第幾日域，系統將在離指定日期的最近的有效工作日觸發事件。注意一點，W的最近尋找不會跨過月份  

    LW : 這兩個字元可以連用，表示在某個月最後一個工作日，即最後一個星期五。  

    # : 用於確定每個月第幾個星期幾，只能出現在每月第幾天域。例如在1#3，表示某月的第三個星期一。4#2 第二個星期四

   （1）cron：cron表示式，指定任務在特定時間執行；

    （2）fixedDelay：表示上一次任務執行完成後多久再次執行，引數型別為long，單位ms；

    （3）fixedDelayString：與fixedDelay含義一樣，只是引數型別變為String；

    （4）fixedRate：表示按一定的頻率執行任務，引數型別為long，單位ms；

    （5）fixedRateString: 與fixedRate的含義一樣，只是將引數型別變為String；

    （6）initialDelay：表示延遲多久再第一次執行任務，引數型別為long，單位ms；

    （7）initialDelayString：與initialDelay的含義一樣，只是將引數型別變為String；
    
  example:
    “0 0 * * * *”                      表示每小時0分0秒執行一次

    ” */10 * * * * *”                 表示每10秒執行一次

    “0 0 8-10 * * *”                 表示每天8，9，10點執行

    “0 0/30 8-10 * * *”            表示每天8點到10點，每半小時執行

    “0 0 9-17 * * MON-FRI”     表示每週一至週五，9點到17點的0分0秒執行

    “0 0 0 25 12 ?”                  表示每年聖誕節（12月25日）0時0分0秒執行
    
    表達式參考:
     https://codertw.com/%E7%A8%8B%E5%BC%8F%E8%AA%9E%E8%A8%80/6009/
     https://gitee.com/jack90john/spring-boot-timmer

@Scheduled(fixedDelay = 5000)        //fixedDelay = 5000表示當前方法執行完畢5000ms後，Spring scheduling會再次呼叫該方法



-------------------以下API-------------------

A cron-like expression, extending the usual UN*X definition to include triggers
	 * on the second, minute, hour, day of month, month, and day of week.
	 * <p>For example, {@code "0 * * * * MON-FRI"} means once per minute on weekdays
	 * (at the top of the minute - the 0th second).
	 * <p>The fields read from left to right are interpreted as follows.
	 * <ul>
	 * <li>second</li>
	 * <li>minute</li>
	 * <li>hour</li>
	 * <li>day of month</li>
	 * <li>month</li>
	 * <li>day of week</li>
	 * </ul>

```
