package ir.madreseyar.teacher

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

enum class TeacherTab(val title:String,val icon:ImageVector){ HOME("خانه",Icons.Default.Home), CLASSES("کلاس‌ها",Icons.Default.Groups), RECORD("ثبت",Icons.Default.EditNote), MESSAGES("پیام‌ها",Icons.Default.Notifications), MORE("بیشتر",Icons.Default.MoreHoriz) }

data class Action(val title:String,val subtitle:String,val icon:ImageVector)

@Composable fun TeacherApp(){
    var tab by remember { mutableStateOf(TeacherTab.HOME) }
    Scaffold(bottomBar={ NavigationBar { TeacherTab.entries.forEach { t -> NavigationBarItem(selected=tab==t,onClick={tab=t},icon={Icon(t.icon,null)},label={Text(t.title)}) } } }) { pad ->
        Box(Modifier.padding(pad).fillMaxSize()) { when(tab){ TeacherTab.HOME->HomeScreen(); TeacherTab.CLASSES->ClassesScreen(); TeacherTab.RECORD->RecordScreen(); TeacherTab.MESSAGES->MessagesScreen(); TeacherTab.MORE->MoreScreen() } }
    }
}

@Composable private fun Header(title:String,subtitle:String?=null){ Column(Modifier.fillMaxWidth().padding(20.dp,18.dp,20.dp,10.dp)){ Text(title,style=MaterialTheme.typography.headlineSmall,fontWeight=FontWeight.Bold); if(subtitle!=null) Text(subtitle,color=MaterialTheme.colorScheme.onSurfaceVariant) } }
@Composable private fun Stat(title:String,value:String,icon:ImageVector){ Card(Modifier.width(160.dp),shape=RoundedCornerShape(18.dp)){ Column(Modifier.padding(16.dp)){ Icon(icon,null,tint=MaterialTheme.colorScheme.primary); Spacer(Modifier.height(10.dp)); Text(value,style=MaterialTheme.typography.headlineSmall,fontWeight=FontWeight.Bold); Text(title,color=MaterialTheme.colorScheme.onSurfaceVariant) } } }
@Composable private fun ActionCard(a:Action){ Card(Modifier.fillMaxWidth(),shape=RoundedCornerShape(16.dp)){ Row(Modifier.padding(16.dp),verticalAlignment=Alignment.CenterVertically){ Surface(shape=RoundedCornerShape(12.dp),color=MaterialTheme.colorScheme.primaryContainer){ Icon(a.icon,null,Modifier.padding(10.dp),tint=MaterialTheme.colorScheme.onPrimaryContainer) }; Spacer(Modifier.width(14.dp)); Column(Modifier.weight(1f)){ Text(a.title,fontWeight=FontWeight.SemiBold); Text(a.subtitle,style=MaterialTheme.typography.bodySmall,color=MaterialTheme.colorScheme.onSurfaceVariant) }; Icon(Icons.Default.ChevronLeft,null) } } }

@Composable private fun HomeScreen(){ LazyColumn(Modifier.fillMaxSize(),contentPadding=PaddingValues(bottom=18.dp),verticalArrangement=Arrangement.spacedBy(10.dp)){ item{Header("مدرسه‌یار معلم","پنل روزانه و ساده برای مدیریت کلاس")}; item{ Card(Modifier.padding(horizontal=16.dp).fillMaxWidth(),shape=RoundedCornerShape(20.dp)){ Column(Modifier.padding(18.dp)){ Text("کلاس بعدی",color=MaterialTheme.colorScheme.primary,fontWeight=FontWeight.Bold); Text("علوم • هفتم A",style=MaterialTheme.typography.titleLarge,fontWeight=FontWeight.Bold); Text("ساعت 08:30 تا 09:15",color=MaterialTheme.colorScheme.onSurfaceVariant); Spacer(Modifier.height(12.dp)); Button(onClick={}){Icon(Icons.Default.PlayArrow,null);Spacer(Modifier.width(6.dp));Text("ورود به کلاس")} } } }; item{ Row(Modifier.padding(horizontal=16.dp),horizontalArrangement=Arrangement.spacedBy(10.dp)){ Stat("تکلیف منتظر تصحیح","۱۲",Icons.Default.Assignment); Stat("آزمون فعال","۱",Icons.Default.Quiz) } }; item{ Text("دسترسی سریع",Modifier.padding(horizontal=20.dp,vertical=6.dp),fontWeight=FontWeight.Bold) }; items(listOf(Action("حضور و غیاب","ثبت سریع حاضر، غایب، تأخیر و موجه",Icons.Default.HowToReg),Action("ثبت نمره","دفتر نمره و مستمر کلاس",Icons.Default.Grading),Action("ساخت تکلیف","تکلیف جدید و پیگیری تحویل‌ها",Icons.Default.AddTask),Action("ساخت آزمون","تستی، تشریحی و زمان‌بندی",Icons.Default.PostAdd))){ Box(Modifier.padding(horizontal=16.dp)){ActionCard(it)} } }
}
@Composable private fun ClassesScreen(){ val list=listOf("هفتم A • علوم","هفتم B • علوم","هشتم A • علوم"); LazyColumn(verticalArrangement=Arrangement.spacedBy(10.dp)){item{Header("کلاس‌های من","دانش‌آموزان، حضور، تکلیف، آزمون و نمره در یکجا")};items(list){c->Box(Modifier.padding(horizontal=16.dp)){ActionCard(Action(c,"مشاهده کلاس و ۶ بخش مدیریتی",Icons.Default.Groups))}}} }
@Composable private fun RecordScreen(){ val a=listOf(Action("حضور و غیاب","ثبت گروهی و مشاهده سابقه",Icons.Default.HowToReg),Action("دفتر نمره","آزمون‌ها، تکالیف، فعالیت و مستمر",Icons.Default.Grading),Action("کارنامه مستمر","پیش‌نمایش، تعدیل با دلیل و صدور",Icons.Default.Assessment),Action("تصحیح تکالیف","نمره و بازخورد معلم",Icons.Default.TaskAlt),Action("تصحیح آزمون","پاسخنامه‌های در انتظار",Icons.Default.FactCheck)); LazyColumn(verticalArrangement=Arrangement.spacedBy(10.dp)){item{Header("ثبت و ارزیابی","کارهای روزانه آموزشی")};items(a){Box(Modifier.padding(horizontal=16.dp)){ActionCard(it)}}} }
@Composable private fun MessagesScreen(){ LazyColumn(verticalArrangement=Arrangement.spacedBy(10.dp)){item{Header("پیام‌ها و اعلان‌ها","اطلاعیه‌های مدرسه و رویدادهای آموزشی")};items(listOf(Action("۱۲ تکلیف جدید تحویل شد","علوم • هفتم A",Icons.Default.AssignmentTurnedIn),Action("آزمون فصل دوم پایان یافت","۲۳ پاسخنامه آماده بررسی",Icons.Default.Quiz),Action("تغییر برنامه فردا","پیام مدیریت مدرسه",Icons.Default.Campaign))){Box(Modifier.padding(horizontal=16.dp)){ActionCard(it)}}} }
@Composable private fun MoreScreen(){ val a=listOf(Action("آزمون‌ها","ساخت، انتشار و تحلیل آزمون",Icons.Default.Quiz),Action("تکالیف","ایجاد و مدیریت تکالیف",Icons.Default.Assignment),Action("منابع آموزشی","PDF، تصویر، جزوه و لینک",Icons.Default.Folder),Action("تحلیل کلاس","میانگین، روند و مباحث نیازمند توجه",Icons.Default.Insights),Action("پروفایل معلم","مشخصات و تنظیمات حساب",Icons.Default.Person),Action("تنظیمات","اعلان‌ها و ظاهر برنامه",Icons.Default.Settings)); LazyColumn(verticalArrangement=Arrangement.spacedBy(10.dp)){item{Header("بیشتر")};items(a){Box(Modifier.padding(horizontal=16.dp)){ActionCard(it)}}} }
