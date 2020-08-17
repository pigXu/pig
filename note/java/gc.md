垃圾回收器
    Serial 单线程新生代 stw
    Serial old 单线程老年代 stw
            清理的内存有限 几十M
    Ps 多线程新生代 stw
    Po 多线程老年代 stw
            清理的内存有限 几G
    CMS 并发清理 stw短 承上启下 内存碎片 最坏情况退化到Serial old
        三色标记
        过程
            初始化标记 stw
            并发标记
            重新标记 stw
            清理
