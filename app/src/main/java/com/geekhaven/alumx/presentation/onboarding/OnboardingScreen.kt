package com.geekhaven.alumx.presentation.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.geekhaven.alumx.R

// Custom Colors from verified design
val BackgroundDark = Color(0xFF0F1116)
val PrimaryBlue = Color(0xFF2563EB)
val TextGrey = Color(0xFF9CA3AF)
val BorderGrey = Color(0xFF374151)

@Composable
fun OnboardingScreen(onGetStarted: () -> Unit) {
    val pagerState = rememberPagerState(pageCount = { 3 })

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundDark)
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // --- Header (Logo) ---
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            // Placeholder for logo icon (Blue Box)
            Box(
                modifier = Modifier
                    .size(32.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(PrimaryBlue),
                contentAlignment = Alignment.Center
            ) {
                 // Simple icon shape
                 Box(modifier = Modifier.size(16.dp).background(Color.White, RoundedCornerShape(2.dp)))
            }
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "AlumX",
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                letterSpacing = (-0.5).sp
            )
        }
        
        Spacer(modifier = Modifier.height(32.dp))

        // --- Image Container ---
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(320.dp)
                .clip(RoundedCornerShape(24.dp))
                .background(Color(0xFFE0E0E0)) // Fallback/Placeholder color
        ) {
             // In a real app, use painterResource(id = R.drawable.onboarding_img)
             // Simulating the grayscale team image look with a placeholder
             Box(
                 modifier = Modifier
                     .fillMaxSize()
                     .background(Color.DarkGray)
             )
        }

        Spacer(modifier = Modifier.height(24.dp))

        // --- Pager Indicators ---
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            repeat(3) { index ->
                val isSelected = pagerState.currentPage == index
                val width = if (isSelected) 32.dp else 6.dp
                val color = if (isSelected) PrimaryBlue else BorderGrey

                Box(
                    modifier = Modifier
                        .height(6.dp)
                        .width(width)
                        .clip(RoundedCornerShape(3.dp))
                        .background(color)
                )
                if (index < 2) Spacer(modifier = Modifier.width(8.dp))
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        // --- Pager Content (Headline & Subtext) ---
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.weight(1f)
        ) { page ->
             Column(
                 horizontalAlignment = Alignment.CenterHorizontally,
                 verticalArrangement = Arrangement.Top
             ) {
                // Headlines based on page
                val headlineText = when(page) {
                    0 -> buildAnnotatedString {
                        append("Connect. ")
                        withStyle(style = SpanStyle(color = PrimaryBlue)) { append("Mentor.") }
                        append(" Grow.")
                    }
                    1 -> buildAnnotatedString {
                         append("Network with ")
                         withStyle(style = SpanStyle(color = PrimaryBlue)) { append("Alumni.") }
                    }
                    else -> buildAnnotatedString {
                        append("Unlock ")
                        withStyle(style = SpanStyle(color = PrimaryBlue)) { append("Careers.") }
                    }
                }
                
                val subText = when(page) {
                    0 -> "Join the ultimate alumni network. Access mentorship, blogs, and career tools all in one place."
                    1 -> "Find mentors from your dream companies and get guidance on your career path."
                    else -> "Get exclusive job referrals and stay updated with the latest industry trends."
                }

                 Text(
                     text = headlineText,
                     color = Color.White,
                     fontSize = 28.sp,
                     fontWeight = FontWeight.Bold,
                     textAlign = TextAlign.Center,
                     lineHeight = 34.sp
                 )
                 
                 Spacer(modifier = Modifier.height(12.dp))
                 
                 Text(
                     text = subText,
                     color = TextGrey,
                     fontSize = 15.sp,
                     textAlign = TextAlign.Center,
                     lineHeight = 22.sp
                 )
             }
        }

        // --- Bottom Buttons ---
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            // Primary Button "Get Started"
            Button(
                onClick = onGetStarted,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = PrimaryBlue,
                    contentColor = Color.White
                )
            ) {
                Text(
                    text = "Get Started",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }
            
            Spacer(modifier = Modifier.height(12.dp))
            
            // Outline Button "Log In"
            Button(
                onClick = onGetStarted, // Routes to same login for now
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .border(1.dp, BorderGrey, RoundedCornerShape(12.dp)),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent,
                    contentColor = Color.White
                ),
                elevation = null
            ) {
                Text(
                    text = "Log In",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }
            
             Spacer(modifier = Modifier.height(16.dp))
             
             // Footer
             Text(
                 text = "By continuing, you accept our Terms of Service",
                 color = Color(0xFF6B7280),
                 fontSize = 12.sp,
                 textAlign = TextAlign.Center
             )
        }
    }
}
