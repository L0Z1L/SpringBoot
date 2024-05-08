#!/usr/bin/env python
# coding: utf-8

# In[1]:


from pyecharts import options as opts
from pyecharts.charts import Bar, Page
from pyecharts.globals import ThemeType
import pymysql
from sqlalchemy import create_engine
import pandas as  pd
import numpy as np
import random
import datetime


# In[2]:


engine =create_engine('mysql+pymysql://root:root@192.168.3.128:3306/dblab?charset=utf8mb4')


# In[3]:


data= pd.read_sql_table('user_action',engine)


# In[4]:


bar_data=data['behavior_type'].value_counts()
bar_data


# In[5]:


import sqlalchemy
bar_data.to_sql('bar_data', con = engine, if_exists = 'replace', index = False)


# In[6]:


data_item=data['item_category'].value_counts()
data_item=data_item.sort_values(ascending=False).head(10)


# In[12]:


data_item.to_sql('scatter_item', con = engine, if_exists = 'replace', index = False)


# In[30]:


data_time=pd.DataFrame()
data_time['Time']=pd.to_datetime(data['visit_date'])
data_time['Year']=data_time['Time'].dt.year
data_time['Month']=data_time['Time'].dt.month
data_time['Year'].value_counts()
datas = data_time['Month'].value_counts()
dataset=np.zeros([2,2])
dataset[0,0]=int(datas.iloc[0])
dataset[1,1]=int(datas.iloc[1])


# In[16]:


pd.DataFrame(dataset).to_sql('shijian_data', con = engine, if_exists = 'replace', index = False)


# In[22]:


dizhi =data['province']
dizhi.value_counts()


# In[23]:


temperature=[int(x) for x in np.array(dizhi.value_counts())]

loc = pd.Series(dizhi.value_counts().index)


# In[24]:


def province(pro):
    provinces = ["北京市", "天津市", "河北省", "山西省", "内蒙古自治区", "辽宁省", "吉林省", "黑龙江省", "上海市", "江苏省", "浙江省", "安徽省", "福建省", "江西省",
                 "山东省", "河南省", "湖北省", "湖南省", "广东省", "广西壮族自治区", "海南省", "重庆市", "四川省", "贵州省", "云南省", "西藏自治区", "陕西省", "甘肃省",
                 "青海省", "宁夏回族自治区", "新疆维吾尔自治区", "台湾省", "香港特别行政区", "澳门特别行政区"]

    # for p in provinces:
    #     if p.find(pro) >= 0:
    #         return p
    #         break

    for p in provinces:
        if pro in p:
            return p
            break


# In[25]:


for i in range(0,len(loc)):
    loc[i]=province(loc[i])


# In[29]:


pd.DataFrame([list(z) for z in zip(loc, temperature)]).to_sql('china_data', con = engine, if_exists = 'replace', index = False)


# In[ ]:




