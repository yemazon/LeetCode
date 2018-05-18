//class NextPermutation {
//public void nextPermutation(vector<int>& nums)
//    {
//        int keyIndex=nums.size()-1;//指向最后一个数
//        while(keyIndex>0&&nums.at(keyIndex)<=nums.at(keyIndex-1))
//            keyIndex--;//寻找降序关键点
//
//
//        if(keyIndex==0)//如果关键点下标为0，则原数据排列为全降序，不存在比它更大的数，将原排列升序重排
//        {
//            sort(nums.begin(),nums.end())
//        }
//        else
//        {
//            int minNum=nums[keyIndex-1];//关键点下标对应的待替换数字
//            for(int i=nums.size()-1;i>keyIndex-1;i--)//寻找关键点后最小的且大于待替换数字的数据对应的下标
//            {
//                if(nums[i]>minNum)//找到，则替换
//                {
//                    int temp;
//                    temp=nums[i];
//                    nums[i]=nums[keyIndex-1];
//                    nums[keyIndex-1]=temp;
//                    break;
//                }
//            }
//            sort(nums.begin()+keyIndex,nums.end());//将替换后，关键点后的数据进行升序重排
//        }
//    }
//}
//
//
